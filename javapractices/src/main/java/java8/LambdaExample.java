package java8;

import java.util.Comparator;

public class LambdaExample {

	public static void main(String[] args) {

		// comparing 2 strings without lambda

		Comparator<String> anonymous = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};

		int val = anonymous.compare("String1", "String2");

		System.out.println(val);
		
		//Comparing with lambda
		
		Comparator<String> lambda = (a,b)->{return a.compareTo(b);};
		lambda.compare("String1", "String2");
		
		//In case of a single statement {} can be excluded and return as well
		
		Comparator<String> lambda1 = (a,b)-> a.compareTo(b);
		lambda1.compare("String1", "String2");
	}

}
