package interview;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArraysAndStrings {
	
	public static void main(String[] args) {
		ArraysAndStrings aas = new ArraysAndStrings();
//		aas.uniqueChars();
//		aas.permuations();
//		aas.compress();
		aas.rotate();
	}
	
	
	public static void quicksort(int[] things) {
		quicksort(things,  0, things.length - 1);
	}
	
	private static void quicksort(int[] a, int lo, int hi) {
		if(hi <= lo) 
			return;
		
		int p = partition(a, lo, hi);
		quicksort(a, lo, p - 1);
		quicksort(a, p + 1, hi);
	}
	
	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi;
		while(true) {
			while(a[++i] < a[lo]) {
				if(i == hi)
					break;
			}
			
			while(a[lo] < a[--j]) {
				if(j == lo)
					break;
			}
			
			if(i >= j)
				break;
			
			exch(a, i, j);
		}
		
		exch(a, lo, j); // Puts the low thing in the middle I guess
		return j;
	}
	
	private static void exch(int[] things, int a, int b) {
		if(b > a) {
			b = b - a;
			a = a + b;
			b = a - b;
		} else {
			b = b - a;
			a = a + b;
			b = a - b;
		}
	}
	
	void rotate() {
		int[][] img = new int[][] {
			{ 1, 2, 3 },
			{ 4 ,5 ,6 },
			{ 7, 8, 9 }
		};
		
		printArray(img);
		int[][] out = rotate(img);
		System.out.println();
		printArray(out);
	}
	
	void printArray(int[][] img) {
		for(int i = 0; i < img.length; i++) {
			for(int j = 0; j < img[i].length; j++) {
				System.out.print(img[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	int[][] rotate(int[][] img) {
		  int temp;
		  int m = img.length;
		  
		  int mLen = m % 2 == 0 ? m / 2 : m / 2 + 1; 
		  
		  int n = img[0].length;
		  for(int i = 0; i < mLen; i++) {
		    for(int j = 0; j < mLen; j++) {
		      temp = img[m - i - 1][j];
		      img[m - i - 1][j] = img[i][j];
			img[i][j] = img[m - i - 1][n - j - 1]; // Save this
		      img[m - i - 1][n - j - 1] = temp;
			temp = img[i][n - j - 1];
		      img[i][n - j - 1] = img[i][j];
		      img[i][j] = temp;
		    }
		  }

		  return img;
		}

	
	void compress() {
		String[] ss = new String[] {
		  "aabcccccaaa", "aaaaa", "aaabbbccc", "abcdefgh"	
		};
		for(String s : ss) {
			String ret = compress(s);
			System.out.println(String.format("%s: %s", s, ret));
		}
	}
	
	String compress(String s) {
	  char current = s.charAt(0);
	  int count = 1;
	  String output = "";
	  for(int i = 1; i < s.length(); i++) {
	    if(current == s.charAt(i)) {
	      count++;
	    } else {
	      output += "" + current + count;
	      current = s.charAt(i);
	      count = 1;
	    }
	  }
	  
	  output += "" + current + count;

	  if(output.length() >= s.length())
	    return s;
	  else
	    return output;
	}
	
	void permuations() {
		String[][] ss = new String[][] {
			{ "yes", "eys" },
			{ "no", "np" },
			{ "the quick brown fox jumped over the lazy dog", "abcdefghijklmnopqrstuvwxyz" }
		};
		
		for(String[] s : ss) {
			boolean ret = permutation(s[0], s[1]);
			System.out.println(String.format("%s, %s: %b", s[0], s[1], ret));
		}
	}
	
	boolean permutation(String s, String t) {
		  char[] cs = s.toCharArray();
		  char[] ct = s.toCharArray();

		  if(cs.length != ct.length)
		    return false;

		  Arrays.sort(cs);
		  Arrays.sort(ct);

		  for(int i = 0; i < cs.length; i++) {
		    if(cs[i] != ct[i]) {
		      return false;
		    }
		  }

		  return true;
		}
	
	void uniqueChars() {
		
		String[] ss = new String[] {
			"Hello", "bye", "yes", "noo"
		};
		for(String s : ss) {
			boolean ret = uniqueChars(s);
			System.out.println(String.format("%s: %bs", s, ret));
		}
	}

	
	boolean uniqueChars(String s) {
	  HashMap<Character, Character> map = new HashMap<Character, Character>();
	  for(int i = 0; i < s.length(); i++) {
	    if(map.containsKey(s.charAt(i))) {
	      return false;
	    } else {
	      map.put(s.charAt(i), s.charAt(i));
	    }
	  }
	  return true;
	}
	
	
	
	
	
	
}
