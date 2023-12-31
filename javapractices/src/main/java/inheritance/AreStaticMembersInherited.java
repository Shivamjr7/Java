package inheritance;

public class AreStaticMembersInherited extends StaticMemberTest {

    boolean isBool  = true;
    public static void main(String[] args) {
        StaticMemberTest obj = new AreStaticMembersInherited();

        System.out.println(integer); // inherited

        System.out.println(obj.isBool);

        hello();
    }

}

class StaticMemberTest{
    static int integer = 10;
    boolean isBool = false;
    static void hello(){
        System.out.println("service call...");
    }

}
