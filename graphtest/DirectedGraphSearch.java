package graphtest;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraphSearch 
{
	private boolean[] marked;
	
	public DirectedGraphSearch(String filename) {
		try {
			Digraph g = new Digraph(filename);
			marked = new boolean[g.V()];
			System.out.print("DFS: ");
			ddfs(g);
			System.out.println();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private int getNextNode() {
		for(int i = 0; i < marked.length; i++) {
			if(!marked[i])
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		DirectedGraphSearch gs = new DirectedGraphSearch("tinyDG.txt");
	}
	
	public void ddfs(Digraph g) {
		
		int node = -1;
		while((node = this.getNextNode()) != -1) {
			ddfs(g, node);
		}
	}
	
	public void ddfs(Digraph g, int node) {
		
		marked[node] = true;
		System.out.print(node + "  ");
		
		for(int child : g.adj(node)) {
			
			if(!marked[child])
				ddfs(g, child);
		}
	}
}
