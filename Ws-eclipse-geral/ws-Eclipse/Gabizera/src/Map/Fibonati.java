package Map;

import java.util.Arrays;
import java.util.stream.Stream;

public class Fibonati {

	public static void main(String[] args) {
		Stream<Long> st4 = Stream.iterate(new Long[] {0L, 1L},p -> new Long[] {p[1], p[0] + p[1]}).map(p -> p[0]);
		System.out.println(Arrays.toString(st4.limit(100).toArray()));

	}

}
