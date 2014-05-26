package graphtest;

import java.io.IOException;
import java.util.ArrayList;

import princeton.IndexMinPQ;

/*************************************
 * 
 * So Primm's is Dijksta's but picking the nearest of those that's in the thing, and
 * those that aren't.
 * 
 * 
 * @author andy
 *
 */

public class Primm 
{
	public Edge[] edgeTo;
	private double[] distTo;
	public boolean[] marked;
	public IndexMinPQ<Double> pq;
	
	public static void main(String[] args) {
		Primm p = new Primm("tinyWg.txt");
	}
	
	public Primm(String filename) {
		try {
			WeightedGraph g = new WeightedGraph(filename);
			marked = new boolean[g.V()];
			edgeTo = new Edge[g.V()];
			distTo = new double[g.V()];
			pq = new IndexMinPQ<Double>(g.V());
			for(int i = 0; i < distTo.length; i++)
				distTo[i] = Double.POSITIVE_INFINITY;
			
			for(int i = 0; i < g.V(); i++) {
				if(!marked[i])
					prim(g, i);
			}
						
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prim(WeightedGraph g, int source) {
		// Initialise the source -> there's nothing in it
		distTo[source] = 0;
		pq.insert(source, distTo[source]);
		while(!pq.isEmpty()) {
			int v = pq.delMin();
			scan(g, v);
		}
	}
	
	private void scan(WeightedGraph g, int node) {
		
	}
}
