package inheritance;

public class AmiguityMultipleArg {

	public static void main(String[] args) {
		
		
		
//		new AmiguityMultipleArg().hello(null, null);
//		 ambiguty issue

	}
	
	
	void hello(String a , Object b)
	{
		
	}
	
	void hello(Object a , String b)
	{
		
	}

}
