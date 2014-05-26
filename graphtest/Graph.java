package graphtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
	
	private int V; // Number of vertices
	private int E; // Number of edges
	private ArrayList<Integer>[] adj; // The list of adjacencies for all nodes
	
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		this.adj = (ArrayList<Integer>[]) new ArrayList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public Graph(String filename) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(filename));
		this.V = Integer.parseInt(in.readLine());
		this.E = Integer.parseInt(in.readLine());
		if(E < 0)  return;
		
		this.adj = (ArrayList<Integer>[]) new ArrayList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
				
		for(int i = 0; i < E; i++) {
			
			String line = in.readLine();
			String[] split = line.split(" ");
			
			int v = Integer.parseInt(split[0]);
			int w = Integer.parseInt(split[1]);
			addEdge(v, w);
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int V(){
		return V;
	}
	
	public int E() {
		return E;
	}
}
