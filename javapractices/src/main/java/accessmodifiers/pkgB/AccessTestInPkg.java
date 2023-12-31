package accessmodifiers.pkgB;

import accessmodifiers.pkgA.AccessTest;

public class AccessTestInPkg extends AccessTest{

    public static void main(String[] args) {
        AccessTest accessTest = new AccessTest();
        System.out.println(accessTest.d);

        AccessTestInPkg accessTestInPkg = new AccessTestInPkg();
        System.out.println(accessTestInPkg.c);

        accessTestInPkg.sayHello();
    }
}

