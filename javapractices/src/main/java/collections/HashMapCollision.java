package collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapCollision {

	
	static Map<String , String> map = new HashMap<String , String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		map.put("key","value");
		map.put("key", "value1");
		
		
		
		System.out.println(map.get("key"));
		
	}

}
