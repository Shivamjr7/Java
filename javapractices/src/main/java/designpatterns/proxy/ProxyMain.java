package designpatterns.proxy;

public class ProxyMain {


    public static void main(String[] args) {

        ExpensiveObject object = new ExpensiveObjectProxy();

        object.process();

        //2nd time heavy init will not occur
        object.process();
    }
}
