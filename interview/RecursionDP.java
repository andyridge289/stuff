package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionDP {
	
	public static void main(String[] args) {
		RecursionDP rdp = new RecursionDP(); 
//		rdp.magicIndex();
		rdp.getSubsets();
	}
	
	void getSubsets() {
		List<Integer> stuff = Arrays.asList(0, 1, 2);
		ArrayList<Integer> stuff2 = new ArrayList<Integer>();
		for(int i : stuff)
			stuff2.add(i);
		
		ArrayList<ArrayList<Integer>> results = getSubsets(stuff2);
		for(ArrayList<Integer> subset : results) {
			System.out.print("{");
			for(int thing : subset) {
				System.out.print(thing + " ");
			}
			System.out.println("}");
		}
	}
	
	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
	  return getSubsets(set, set.size() - 1);
	}

	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int end) {
	  if(end == 0) {
	    ArrayList<Integer> thisSet = new ArrayList<Integer>();
	    ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
	    sets.add(thisSet);
	    return sets;
	  } else {
	    ArrayList<ArrayList<Integer>> sets = getSubsets(set, end - 1);
	    for(ArrayList<Integer> s : sets) {
	      ArrayList<Integer> aSet = new ArrayList<Integer>();
	      for(int i : s) {
	       aSet.add(i);
	      }
	      aSet.add(set.get(end));
	      sets.add(aSet);
	    }
	    return sets;
	  }
	}

	
	void magicIndex() {
	  int[] arr = new int[] {
		-1, 0, 1, 2, 4, 5, 8	  
	  };
	  System.out.println(magicIndex(arr));
	}
	
	int magicIndex(int[] arr) {
	  return magicIndex(arr, 0, arr.length);
	}
	
	int magicIndex(int[] arr, int start, int end) {
		
	  int mid = (end - start) / 2 + start;
	  System.out.println(start + " " + end + " = " + mid);
	  
	  if(start == end)
		  return -1;
	  
	  
	  if(arr[mid] == mid) {
	    return mid;
	  } else if(arr[mid] > mid) {
	    // Go left
		  System.out.println("Left! " + 0 + ", " + mid);
	    return magicIndex(arr, 0, mid - 1); 
	  } else {
	    // Go right
		  System.out.println("Right! " + mid + ", " + end);
	    return magicIndex(arr, mid + 1, end);
	    
	  }
	}

	

}
