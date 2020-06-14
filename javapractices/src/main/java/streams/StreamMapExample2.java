package streams;

import java.util.Arrays;
import java.util.List;

public class StreamMapExample2 {

	public static void main(String[] args) {
		
		
		List<String> list = Arrays.asList("Park Ji Sung","Harry Kane","Rashford");
		
		
		list.stream()
		.map(x-> x.toLowerCase())
		.filter(x-> x.startsWith("r"))
		.forEach(System.out::println);

	}

}
