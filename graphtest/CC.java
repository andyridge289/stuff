package graphtest;

import java.io.IOException;

public class CC 
{
	private int[] cc;
	private int count;
	
	public static void main(String[] args) {
		CC cc = new CC("tinyG.txt");
	}
	
	public CC(String filename) {
		try {
			
			Graph g = new Graph(filename);
			cc = new int[g.V()];
			for(int i = 0; i < cc.length; i++) {
				cc[i] = -1;
			}
			count = 0;
			connectedComponents(g);
			
			System.out.print("CC: ");
			for(int c : cc){
				System.out.print(c + "  ");
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private int getNextNode() {
		for(int i = 0; i < cc.length; i++) {
			if(cc[i] == -1)
				return i;
		}
		return -1;
	}
	
	
	public void connectedComponents(Graph g) {
		
		int node = -1;
		while((node = this.getNextNode()) != -1) {
		
			cc(g, node);
			count++;
		}
	}
	
	public void cc(Graph g, int node) {
		
		cc[node] = count;
		
		for(int i : g.adj(node)) {
			if(cc[i] == -1) {
				cc(g, i);
			}
		}
	}

}
