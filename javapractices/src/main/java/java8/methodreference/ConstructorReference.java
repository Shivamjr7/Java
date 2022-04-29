package java8.methodreference;

import java.util.function.Supplier;

public class ConstructorReference {

    public static void main(String[] args) {
        Supplier<String>  supplier = String::new;

    }
}
