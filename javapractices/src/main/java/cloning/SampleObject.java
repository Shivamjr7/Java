package cloning;

import java.util.ArrayList;
import java.util.List;

public class SampleObject implements Cloneable{

    private String objectName ;
    private int objectVal;

    private List<String> objectList;


    SampleObject(String name , int val, List<String> list){
        this.objectName = name;
        this.objectVal = val;
        this.objectList = list;

    }


    public static void main(String[] args) throws CloneNotSupportedException {

        List<String> list = new ArrayList<>();
        SampleObject object1  = new SampleObject("Object1",1,list);

        SampleObject object2 = (SampleObject) object1.clone();
        System.out.println(object2==object1); // created a shallow copy

        // since it is not a deep copy , it will have same object list for both
        System.out.println(object1.objectList == object2.objectList);

        // serialization and deserialization creates a deep copy
        // or use copy constructors
    }
}
