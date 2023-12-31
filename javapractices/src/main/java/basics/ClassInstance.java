package basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassInstance {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Object object = new Object();
        Class<?> objectClass = object.getClass();

        SampleClass sampleClass = new SampleClass(1);
        System.out.println(sampleClass.getClass().getCanonicalName());
        Constructor<?> constructor = sampleClass.getClass().getDeclaredConstructor(int.class);
        
    }
}

class SampleClass {

    SampleClass(){

    }
    int a ;
    SampleClass(int a ){
     this.a = a;
    }
}