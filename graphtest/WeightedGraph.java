package graphtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WeightedGraph 
{
	private int V; // Number of vertices
	private int E; // Number of edges
	private ArrayList<Edge>[] adj; // The list of adjacencies for all nodes
	
	public WeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		this.adj = (ArrayList<Edge>[]) new ArrayList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Edge>();
		}
	}
	
	public WeightedGraph(String filename) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(filename));
		this.V = Integer.parseInt(in.readLine());
		this.E = Integer.parseInt(in.readLine());
		if(E < 0)  return;
		
		this.adj = (ArrayList<Edge>[]) new ArrayList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Edge>();
		}
				
		for(int i = 0; i < E; i++) {
			
			String line = in.readLine();
			String[] split = line.split(" ");
				
			int v = Integer.parseInt(split[0]);
			int w = Integer.parseInt(split[1]);
			double weight = Double.parseDouble(split[2]);
			addEdge(v, w, weight);
		}
	}
	
	public void addEdge(int v, int w, double weight) {
		adj[v].add(new Edge(v, w, weight));
		adj[w].add(new Edge(w, v, weight));
	}
	
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}
	
	public int V(){
		return V;
	}
	
	public int E() {
		return E;
	}
}
