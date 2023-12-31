package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOptimize {

    public static void main(String[] args) {

        Map<String , List<String>> map1 = new HashMap<>();

        map1.put("key1",new ArrayList<>());
        map1.get("key1").add("data1");
        map1.get("key1").add("data2");


        String keyParse = "key1";
        String [] keyvalues = {"1","2","3"};


        List<String> list = map1.get("key1");

        if(list.size()>1)
        {
            for(String li : list){

                for(String ke : keyvalues)
                {
                    System.out.println(li +" :"+ ke);
                }
            }

        }


    }
}
