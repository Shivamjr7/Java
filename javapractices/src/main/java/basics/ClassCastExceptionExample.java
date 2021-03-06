package basics;

public class ClassCastExceptionExample {

	public static void main(String[] args) {
		

		
		/**
		 * This will throw class cast exception
		 */
		
		Base base = new Base();
		Derived  d = (Derived) base;
		d.hello();
		
		
		/**
		 * This will not throw
		 */
		
		Base b = new Derived();
		Derived d1 = (Derived) b;
		d1.hello();
		
	}

}



class Base
{
	void hello()
	{
		System.out.println("Hello Base");
	}
}


class Derived extends Base
{
	
}