package inheritance;

public class MethodOverloadingAmbiguity {

	public static void main(String[] args) {
		
		
		//String will be called as it is down in heirarchy
		new MethodOverloadingAmbiguity().hello(null);

	}
	
	
	void hello(Object a)
	{
		System.out.println("Object called");
	}
	
	
	void hello(String a)
	{
		System.out.println("String called");
	}

}


