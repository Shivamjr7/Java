package java8;

import java.util.ArrayList;
import java.util.List;

public class PredicateExample {

	public static void main(String[] args) {
	
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		//remove if accepts a predicate
		//Predicate is FI which takes a input and returns a boolean
		list.removeIf(n-> n>2);
		
		
		for(int n : list)
		{
			System.out.println(n);
		}
		

	}

}
