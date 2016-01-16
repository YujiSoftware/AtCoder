import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input =
			"4 4" + System.lineSeparator() +
				"1 1 4 2" + System.lineSeparator() +
				"3 0 1 2 3" + System.lineSeparator() +
				"2 -2 1 3" + System.lineSeparator() +
				"3 0 3 1 3";
		String output =
			"2 4" + System.lineSeparator() +
				"5 7";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"50 20" + System.lineSeparator() +
				"2 5 40 6" + System.lineSeparator() +
				"1 69 94 5" + System.lineSeparator() +
				"3 8 39 31 32" + System.lineSeparator() +
				"2 -29 -21 -10" + System.lineSeparator() +
				"2 20 43 3" + System.lineSeparator() +
				"2 -37 36 -10" + System.lineSeparator() +
				"2 -18 45 5" + System.lineSeparator() +
				"2 30 39 -2" + System.lineSeparator() +
				"3 0 1 19 33" + System.lineSeparator() +
				"3 27 47 0 43" + System.lineSeparator() +
				"3 0 1 28 39" + System.lineSeparator() +
				"1 90 97 0" + System.lineSeparator() +
				"2 -46 31 7" + System.lineSeparator() +
				"1 81 81 4" + System.lineSeparator() +
				"1 11 54 3" + System.lineSeparator() +
				"3 10 29 26 30" + System.lineSeparator() +
				"1 39 45 3" + System.lineSeparator() +
				"1 70 97 -4" + System.lineSeparator() +
				"3 24 46 14 34" + System.lineSeparator() +
				"3 1 18 48 48";
		String output =
			"11 5" + System.lineSeparator() +
				"-5 1" + System.lineSeparator() +
				"14 8" + System.lineSeparator() +
				"0 3" + System.lineSeparator() +
				"5 82" + System.lineSeparator() +
				"16 2" + System.lineSeparator() +
				"10 5";

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
