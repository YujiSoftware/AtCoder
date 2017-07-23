import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3 7" + System.lineSeparator() +
				"9 3 4";
		String output = "POSSIBLE";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "3 5" + System.lineSeparator() +
				"6 9 3";
		String output = "IMPOSSIBLE";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "4 11" + System.lineSeparator() +
				"11 3 7 15";
		String output = "POSSIBLE";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "5 12" + System.lineSeparator() +
				"10 2 8 6 4";
		String output = "IMPOSSIBLE";

		assertIO(input, output);
	}

	@Test
	public void 入力例_MAX() throws Exception {
		String input = "100000 99999999" + System.lineSeparator() +
				IntStream.rangeClosed(0, 99999)
						.mapToObj(i -> Integer.toString(1_000_000_000 - i * 2))
						.collect(Collectors.joining(" "));
		String output = "IMPOSSIBLE";

		assertIO(input, output);
	}

	@Test
	public void 入力例_MIN1() throws Exception {
		String input = "1 100" + System.lineSeparator() +
				"100";
		String output = "POSSIBLE";

		assertIO(input, output);
	}

	@Test
	public void 入力例_MIN2() throws Exception {
		String input = "1 100" + System.lineSeparator() +
				"99";
		String output = "IMPOSSIBLE";

		assertIO(input, output);
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
