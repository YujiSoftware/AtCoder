import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input =
			"7 6" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"2";
		String output =
			"4";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"6 10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"10";
		String output =
			"6";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input =
			"6 9" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10";
		String output =
			"0";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input =
			"4 0" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"4";
		String output =
			"0";

		assertIO(input, output);
	}

	@Test()
	public void 入力例5() throws Exception {
		String input = "";
		input +=
			"100000 1000000000" + System.lineSeparator();
		input +=
			String.join(System.lineSeparator(),
				Stream.generate(() -> "1").limit(100000).collect(Collectors.toList()));

		String output =
			"100000";

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
