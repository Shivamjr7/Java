package generics;

import java.util.ArrayList;
import java.util.List;

public class PECS {

	public static void main(String[] args) {
		
		
	}

	
	
	void add(List<? extends Fruit> list)
	{
	
		list.forEach(System.out::println);
//		list.add(new Apple()); not allowed 
	}
	
	 void  addnew(List<? super Apple> list)
	{
		list.add(new Apple());
		list.add(new AsianApple());
//		list.add(new Fruit()); not allowed
	}
}


class Fruit 
{
	
}

class Apple extends Fruit {
	
}

class AsianApple extends Apple
{
	
}