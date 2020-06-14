package streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class SummayStatistics {

	public static void main(String[] args) {

		IntSummaryStatistics summary = IntStream.of(1, 10).summaryStatistics();
		System.out.println(summary);
	}

}
