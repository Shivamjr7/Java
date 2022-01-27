package basics;



import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EnumExample {


    public static void main(String[] args) {

        //get the enum
        //this will fetch based on actual enum name and not the value
        Sports sports = Sports.valueOf("FOOTBALL");


        //this will fetch based on string value
        Sports sportsFromString = Sports.get("football");




    }

}


enum Sports{

    FOOTBALL("football"),
    CRICKET("cricket");

    private String value;
    Sports(String value)
    {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    private static final Map<String, Sports> ENUM_MAP;

    static{
        Map<String, Sports> map = new ConcurrentHashMap<>();
        for (Sports instance : Sports.values()) {
            map.put(instance.getValue().toLowerCase(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Sports get(String name) {
        return ENUM_MAP.get(name.toLowerCase());
    }

}
