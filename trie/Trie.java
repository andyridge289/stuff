package trie;

import javax.jws.WebParam.Mode;

public class Trie 
{
	public static final int R = 26;
	
	private Node root;
	private int N;

	public Trie() {
	}
	
	public void put(String word, Object value) {
		if(value == null)
			delete(word);
		else 
			root = put(root, word, value, 0);
	}
	
	private Node put(Node node, String word, Object value, int count) {
		if(node == null) {
			node = new Node();
		}
		
		if(count == word.length()) {
			if(node.value == null)
				N++;
			
			node.value = value;
			return node;
		}
		
		char c = word.charAt(count);
		node.next[c] = put(node.next[c], word, value, count + 1);
		return node;
	}
	
	 public void delete(String key) {
	        root = delete(root, key, 0);
	    }
	 
	 public Object get(String key) {
	        Node x = get(root, key, 0);
	        if (x == null) return null;
	        return x.value;
	    }

	    /**
	     * Does this symbol table contain the given key?
	     * @param key the key
	     * @return <tt>true</tt> if this symbol table contains <tt>key</tt> and
	     *     <tt>false</tt> otherwise
	     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
	     */
	    public boolean contains(String key) {
	        return get(key) != null;
	    }

	    private Node get(Node x, String key, int d) {
	        if (x == null) return null;
	        if (d == key.length()) return x;
	        char c = key.charAt(d);
	        return get(x.next[c], key, d+1);
	    }


	
	private Node delete(Node x, String key, int d) {
		 if (x == null) return null;
	        if (d == key.length()) {
	            if (x.value != null) N--;
	            x.value = null;
	        }
	        else {
	            char c = key.charAt(d);
	            x.next[c] = delete(x.next[c], key, d+1);
	        }

	        // remove subtrie rooted at x if it is completely empty
	        if (x.value != null) return x;
	        for (int c = 0; c < R; c++)
	            if (x.next[c] != null)
	                return x;
	        return null;
	}
	
	private class Node {
		private Object value;
		private Node[] next = new Node[R];
	}
	
	
}
