package graphtest;

import java.io.IOException;

public class Paths 
{
	private boolean[] marked;
	private int source;
	private int[] edgeTo;
	
	public Paths(String filename) {
		try {
			Digraph g = new Digraph(filename);
			marked = new boolean[g.V()];
//			System.out.print("DFS: ");
//			ddfs(g);
//			System.out.println();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paths(Graph g) {
		
		
		
	}
	
	public void paths(Graph g, int node) {
		
	}
	
	private int getNextNode() {
		for(int i = 0; i < marked.length; i++) {
			if(!marked[i])
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Paths p = new Paths("tinyDG.txt");
	}
}
