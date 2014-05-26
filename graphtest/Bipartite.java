package graphtest;

import java.io.IOException;

public class Bipartite 
{
	public boolean[] marked;
	public boolean[] c = new boolean[]{
		true, false, false, true, true, false, false,
		true, false,
		true, false, false, true
	};
	
	public static void main(String[] args) {
		Bipartite bp = new Bipartite("tinyGBip.txt");
	}
	
	public Bipartite(String filename) {
		try {
			
			Graph g = new Graph(filename);
			marked = new boolean[g.V()];
			boolean ret = bpTest(g);
			System.out.println(ret);
			
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
	
	public boolean bpTest(Graph g) {
		
		int node = -1;
		while((node = this.getNextNode()) != -1) {
		
			if(!bpTest(g, node))
				return false;
		}
		
		return true;
	}
	
	public boolean bpTest(Graph g, int node) {
		
		marked[node]= true;
		for(int i : g.adj(node)) {
			
			if(c[node] == c[i])
				return false;
			else if(!marked[i]) {
				return bpTest(g, i);
			}
		}
		
		return true;
	}
}
