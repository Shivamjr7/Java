package java8;

import java.util.Comparator;
import java.util.function.Function;

public class LambdaExample {

	public static void main(String[] args) {


		/**
		 * What are Lambdas : They are expressions which define implementations of
		 * functional interface methods
		 *
		 * so basically it defines what we can do  - declarative programming
		 *
		 *
		 * Declarative programming - How to do a thing? - with steps
		 * Imperative programming- What things are ? - what a function does
		 */


		/**
		 * Here we have defined what the lambda does - to add 2 variables
		 */
		TestingLambda add = (x ,y)-> {
			System.out.println(x+y);
		};


		add.doSomething(10,15);

		// Function<T,R> is a functional interface in java 8 ,takes an argument and returns a value
		Function<Integer, String> myFunction =(x) -> "Number is  :"+x;
		String str = myFunction.apply(27);
		System.out.println(str);

	}



	@FunctionalInterface
	interface TestingLambda{

		void doSomething(int x , int y);
	}

}
