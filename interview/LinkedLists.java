package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LinkedLists {
	
//	public static void main(String[] args) {
//		LinkedLists ll = new LinkedLists();
//		ll.removeDuplicates();
//	}
	
	void removeDuplicates() {
		ArrayList<String> stuff = new ArrayList<String>();
		stuff.add("hello");
		stuff.add("sdaklj");
		stuff.add("hello");
		stuff.add("goodbye");
		stuff.add("sadfkjasdf");
		stuff.add("goodbye");
		
		for(String s: stuff) {
			System.out.print(s + " ");
		}
		System.out.println();
		removeDuplicates(stuff);
		for(String s: stuff) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	void removeDuplicates(List<String> stuff) {
	  Collections.sort(stuff);
	  for(int i = 1; i < stuff.size(); i++) {
	    if(stuff.get(i - 1).equals(stuff.get(i))) {
	      stuff.remove(i);
	      i--;
	    }
	  }
	}

}
