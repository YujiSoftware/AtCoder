import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "1000 8" + System.lineSeparator() +
				"1 3 4 5 6 7 8 9";
		String output = "2000";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "9999 1" + System.lineSeparator() +
				"0";
		String output = "9999";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "9999 9" + System.lineSeparator() +
				"0 1 2 3 4 5 6 7 9";
		String output = "88888";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "102 1" + System.lineSeparator() +
				"0";
		String output = "111";

		assertIO(input, output);
	}

	@Test
	@Ignore
	public void 入力例_ALL() throws Exception {
		for (int i = 0; i < 9; i++) {
			List<Integer> K = new ArrayList<Integer>();
			K.add(i);

			for (int j = 1; j < 10000; j++) {
				String input = j + " " + K.size() + System.lineSeparator() +
						K.stream().map(value -> Integer.toString(value)).collect(Collectors.joining(" "));

				Set<Integer> set = K.stream().map(value -> value + 0x30).collect(Collectors.toSet());
				int output = j;
				while (Integer.toString(output).chars().anyMatch(c -> set.contains(c))) {
					output++;
				}

				try {
					assertIO(input, Integer.toString(output));
				} catch (Throwable t) {
					System.err.println(input);
					throw t;
				}
			}
		}
	}

	private void assertIO(String input, String output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		Assert.assertThat(out.toString(), is(output + System.lineSeparator()));
	}
}
