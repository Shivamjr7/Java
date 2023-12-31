package abstraction;

public class AbstractTest {

    public static void main(String[] args) {
        // can create
        Phones phones = new IPhone("Iphone");
        phones.displayName();
    }
}


abstract class Phones {

    // Abstract class vs interface
    // can have constructor though
    // can have non abstract methods
    // can have non final variables
    /// cannot create instance of abstract class , if created how will you call abstract methods

    Phones(String name ){
        System.out.println("Hello : " + name);
    }
    abstract void displayName();
}
class IPhone extends Phones{

    String name ;
    IPhone(String name){
        super(name);
        this.name = name ;
    }

    @Override
    void displayName() {
        System.out.println(name);
    }
}