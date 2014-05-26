package tree;

public class BST 
{
	private Node root;
	
	public BST(int key, Object value) {
		this.root = new Node(key, value);
	}
	
	public void add(int key, Object value) {
		add(root, key, value);
	}
	
	private void add(Node node, int key, Object value) {
		if(key <= node.key) {
			// Go left
			if(node.left == null) {
				Node n = new Node(key, value);
				node.left = n;
			} else {
				add(node.left, key, value);
			}
		} else {
			// Go right
			if(node.right == null) {
				Node n = new Node(key, value);
				node.right = n;
			} else {
				add(node.right, key, value);
			}
		}
	}
	
	public Object get(int key) {
		return get(root, key);
	}
	
	private Object get(Node node, int key) {
		if(key == node.key) {
			return node.value;
		} else if(key < node.key) { // Go left
			return get(node.left, key);
		} else { // It must be greater, go right
			return get(node.right, key);
		}
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public int size() {
		return size(root);
	}
	
	public int size(Node node) {
		int left = 0;
		if(node.left != null) {
			left = size(node.left);
		}
		
		int right = 0;
		if(node.right != null) {
			right = size(node.right);
		}
		
		return right + left;
	}
	
	public boolean contains(int key) {
		return contains(root, key);
	}
	
	public boolean contains(Node node, int key) {
		if(key == node.key) {
			return true;
		} else if(key < node.key) { // Go left
			if(node.left == null) {
				return false;
			} else {
				return contains(node.left, key);
			}
		} else { // Go right
			if(node.right == null) {
				return false;
			} else {
				return contains(node.right, key);
			}
		}
	}
	
	private class Node {
		public int key;
		public Object value;
		public Node left;
		public Node right;
		
		private Node(int key, Object value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
}
