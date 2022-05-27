package designpatterns.proxy;

public class ExpensiveObjectProxy implements  ExpensiveObject{


    ExpensiveObjectImpl object;


    @Override
    public void process() {
        if(object==null)
        {
            object = new ExpensiveObjectImpl();
        }

        object.process();
    }
}
