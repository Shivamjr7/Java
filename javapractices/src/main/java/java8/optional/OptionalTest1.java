package java8.optional;

import java.util.Optional;

public class OptionalTest1 {


    public static void main(String[] args) {

        Optional<String> name = getName();
        if (name.isPresent()) {
            System.out.println(name);
        } else {
            System.out.println("name not present ....");
        }

        Optional<String> newName = getNameNew();
        if (newName.isPresent()) {
            System.out.println(newName.get());
        } else {
            System.out.println("Name not present....");
        }


    }

    // method which returns a String

    public static Optional<String> getName() {
        return Optional.ofNullable(null);
    }

    public static Optional<String> getNameNew() {
        return Optional.ofNullable("Shivam");
    }
}
