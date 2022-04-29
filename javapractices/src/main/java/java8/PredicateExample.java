package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

		// returns true if no >2
		Predicate<Integer> predicate1 = (i)-> i>2;

		//returns true if no >3
		Predicate<Integer> predicate2 = (i)-> i>4;

		/**
		 * predicate chaining
		 */
		System.out.println(predicate1.and(predicate2).test(10));
		System.out.println(predicate1.and(predicate2).test(3));
		System.out.println(predicate1.or(predicate2).test(10));
		System.out.println(predicate1.or(predicate2).negate().test(10));


	}

}
