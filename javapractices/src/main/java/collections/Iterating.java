package collections;

import java.util.HashMap;
import java.util.Map;

public class Iterating {


    public static void main(String[] args) {


        Map<String,Context> contextMap = new HashMap<>();

        contextMap.put("node1_subcontext",new Context("Context-A"));
        contextMap.put("normal Key",new Context("Context-B"));
        contextMap.put("node2_subcontext",new Context("Context-C"));



        contextMap.keySet()
                .stream()
                .filter(key ->key.contains("subcontext"))
                .forEach(System.out::println);


        Map<String,Context> contextMap2 = new HashMap<>();


    }



}

class Context{
    String name ;

    Context(String name)
    {
        this.name = name;
    }
}


