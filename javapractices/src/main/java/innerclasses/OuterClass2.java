package innerclasses;

public class OuterClass2 {

    private void test1(){

    }

    static class InnerClass2{
        private int counter  = 10;

    }

    public static void main(String[] args) {
      OuterClass2.InnerClass2 o = new InnerClass2();

    }
}
