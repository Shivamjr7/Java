package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomList<T> {

	
	List<T> list = new ArrayList<T>();
	
	List<? extends T> list1 = new ArrayList<>();
	
	
	void listProcess(List<? extends T> list)
	{
		System.out.println(list.get(0));
	}
	
	
	void listSuper(List<? super T> list1)
	{
		System.out.println(list1.get(0));
	}
	public static void main(String[] args) {

		
		
		//case 1
		CustomList<Integer> obj = new CustomList<>();
		obj.list.add(10);
		
		
		//case 2
		CustomList<String> obj1 = new CustomList<>();
		obj1.list.add("Hello");
		
		//case 3
		CustomList<Number> obj2 = new CustomList<>();
		obj2.listProcess(new ArrayList<>(Arrays.asList(1)));
	
		
		//case 4
		CustomList<Number> obj3 = new CustomList<>();
		List<Number> listofNumbers = new ArrayList<>();
		
		listofNumbers.add(1.0);
		listofNumbers.add(2.0);
		
		obj3.listSuper(listofNumbers);
	
		

	}

}
