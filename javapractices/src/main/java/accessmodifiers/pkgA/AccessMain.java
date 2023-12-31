package accessmodifiers.pkgA;

public class AccessMain {

    public static void main(String[] args) {
        AccessTest accessTest = new AccessTest();
        System.out.println(accessTest.a); // default member
        System.out.println(accessTest.c);  // protected member
        System.out.println(accessTest.d); // public

        // in the same package we can access the protected member using class ref
        accessTest.sayHello();
    }
}
