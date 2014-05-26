package graphtest;

public class Edge {
	
	private int v;
	private int w;
	private double weight;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight() {
		return this.weight;
	}
	
	public int other(int v) {
		return this.v == v ? this.w : this.v;
	}
	
	public int from() {
		return v;
	}
	
	public int to() {
		return w;
	}

}
