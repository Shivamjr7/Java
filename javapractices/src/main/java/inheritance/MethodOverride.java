package inheritance;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MethodOverride extends Sample{

    void hello(){
        System.out.println("subclass");
    }

    // covariant return type
    int method1(){
        return (byte) 1;
    }

      // cannot throw a broad exception
        //    @Override
        //    void fileHandle() throws IOException {
        //        super.fileHandle();
        //    }


    // also covariant
    @Override
    MethodOverride sample() {
        return new MethodOverride();
    }

    public static void main(String[] args) {

        Sample sample = new Sample();
        Sample sample1 = new MethodOverride();
        MethodOverride override = new MethodOverride();

        // basic one
        sample.hello();
        sample1.hello();
        override.hello();

    }
}


class Sample {


    void hello(){
        System.out.println("superclass ");
    }

    int method1(){
        return 1;
    }

    void fileHandle() throws FileNotFoundException {

    }

    Sample sample() {
        return  new Sample();
    }
}