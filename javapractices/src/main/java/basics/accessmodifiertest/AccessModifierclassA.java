package basics.accessmodifiertest;

public class AccessModifierclassA {

    int defaultIntVar = 1;
    String defaultStringVar = "2";
    public boolean publicBoolean =false;
    protected  int protectedInt = 4;
    private int privateInt = 5;


    protected void method()
    {
        System.out.println("This is a protected method");
    }
}
