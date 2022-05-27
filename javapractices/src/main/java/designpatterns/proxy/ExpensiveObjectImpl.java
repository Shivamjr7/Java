package designpatterns.proxy;

public class ExpensiveObjectImpl implements ExpensiveObject {

    public ExpensiveObjectImpl()
    {
        doExpensiveInit();
    }

    void doExpensiveInit()
    {
        System.out.println("Initalizing .. running 4 threads...");
    }


    @Override
    public void process() {
        System.out.println("Processing your data ...");
    }
}
