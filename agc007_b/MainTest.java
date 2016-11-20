import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "2" + System.lineSeparator() +
				"1 2";
		String output = "1 4" + System.lineSeparator() +
				"5 4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "3" + System.lineSeparator() +
				"3 2 1";
		String output = "1 2 3" + System.lineSeparator() +
				"5 3 1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "3" + System.lineSeparator() +
				"2 3 1";
		String output = "5 10 100" + System.lineSeparator() +
				"100 10 1";

		assertIO(input, output);
	}

	private void assertIO(String input, String output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		String[] outLines = out.toString().split(System.lineSeparator());
		int[] a = Stream.of(outLines[0].split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] b = Stream.of(outLines[1].split(" ")).mapToInt(Integer::parseInt).toArray();

		String[] inLines = input.split(System.lineSeparator());
		int N = Integer.parseInt(inLines[0]);
		int[] p = Stream.of(inLines[1].split(" ")).mapToInt(Integer::parseInt).toArray();

		assertThat(a.length, is(N));
		assertThat(b.length, is(N));

		for (int i = 0; i < N - 1; i++) {
			assertTrue(a[i] + "<" + a[i + 1], a[i] < a[i + 1]);
			assertTrue(b[i] + ">" + b[i + 1], b[i] > b[i + 1]);
		}

		for (int i = 0; i < p.length - 1; i++) {
			int current = p[i] - 1;
			int next = p[i + 1] - 1;
			assertTrue(
					String.format("\na[current] = %d, b[current] = %d\na[next] = %d, b[next] = %d)", a[current],
							b[current], a[next], b[next]),
					a[current] + b[current] < a[next] + b[next]);
		}
	}
}
