package collections;

import java.util.HashMap;
import java.util.Map;

public class MapKeys {

    public static void main(String[] args) {


        Map<String , Node> map = new HashMap<>();


        Node node1 = new Node("A");
        Node node2 = new Node("B");

        map.put("1",node1);
        map.put("2",node2);

        Map<String , Node> map1 = new HashMap<>();
        map1.put("3",new Node("C"));
        map1.put("3",new Node("D"));

        map.putAll(map1);

        System.out.print("Hello ...");


    }

}


class Node {

    private String name;


    Node( String name)
    {

        this.name = name;
    }
}
