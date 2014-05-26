package graphtest;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch 
{
	private boolean[] marked;
	
	public GraphSearch(String filename) {
		try {
			Graph g = new Graph(filename);
			marked = new boolean[g.V()];
			System.out.print("DFS: ");
			dfs(g, 0);
			System.out.println();
			
			for(int i = 0; i < marked.length; i++) {
				marked[i] = false;
			}
			
			System.out.print("BFS: ");
			bfs(g, 0);
			System.out.println();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		GraphSearch gs = new GraphSearch("tinyG.txt");
	}
	
	public void dfs(Graph g, int node) {
		
		marked[node] = true;
		System.out.print(node + "  ");
		
		for(int child : g.adj(node)) {
			
			if(!marked[child])
				dfs(g, child);
		}
	}
	
	public void bfs(Graph g, int node) {
		
		System.out.print(node + "  ");
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		q.add(node);
		marked[node] = true;
		
		while(!q.isEmpty()) {
			
			int thing = q.remove();
			
			
			for(int i : g.adj(thing)) {
				
				if(!marked[i]) {
					System.out.print(i + "  ");
					marked[i] = true;
					q.add(i);
					
				}
			}
		}
		
	}
}
