package inheritance;

public class AreMemberVariablesOverriden {

	public static void main(String[] args) {
		
		A obj = new B();
		System.out.println(obj.a); // this will print 10 and not 20 as member variables are not overriden

		System.out.println(obj.b); // this will print 10 and not 20 as member variables are not overriden
	}

}


class A{
	int  a  = 10;
	static int b = 10;
}

class B extends A{
	int a = 20;
	static int b = 20;
}