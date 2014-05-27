package graphtest;

import java.io.IOException;
import java.util.Stack;

public class Topological {

	private boolean[] marked;
	private Stack<Integer> stuff;

	public static void main(String[] args) {
		Topological top = new Topological("dag.txt");
	}
	
	public Topological(String filename) {
		try {
			
			Digraph g = new Digraph(filename);
			marked = new boolean[g.V()];
			stuff = new Stack<Integer>();
			
			for(int i = 0; i < marked.length; i++) {
				
				if(!marked[i])
					topological(g, i);
			}
			
			while(!stuff.isEmpty()) {
				System.out.println(stuff.pop());
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void topological(Digraph g, int n) {
		
		marked[n] = true;
		
		for(int i : g.adj(n)) {
			
			if(!marked[i]) {
				topological(g , i);
			}
		}
		
		System.out.println("Finished with " + n);
		stuff.push(n);
	}
	
	
}
