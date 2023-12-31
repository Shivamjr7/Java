package collections;

import java.util.HashMap;
import java.util.Map;

public class MapDebug {

    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();

        map.put("1", "Shivam");
        map.put("2", "Ronaldo");


        Map<String, String> mapnew = new HashMap<>();
        map.forEach((key, value) -> {
                    mapnew.put(key, value);
                }
        );


        map.put("1","Hello");


        System.out.println(map.get("1"));
        System.out.println(mapnew.get("1"));
    }

}
