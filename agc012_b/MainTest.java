import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "7 7" + System.lineSeparator() +
				"1 2" + System.lineSeparator() +
				"1 3" + System.lineSeparator() +
				"1 4" + System.lineSeparator() +
				"4 5" + System.lineSeparator() +
				"5 6" + System.lineSeparator() +
				"5 7" + System.lineSeparator() +
				"2 3" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"6 1 1" + System.lineSeparator() +
				"1 2 2";
		String output = "2" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "14 10" + System.lineSeparator() +
				"1 4" + System.lineSeparator() +
				"5 7" + System.lineSeparator() +
				"7 11" + System.lineSeparator() +
				"4 10" + System.lineSeparator() +
				"14 7" + System.lineSeparator() +
				"14 3" + System.lineSeparator() +
				"6 14" + System.lineSeparator() +
				"8 11" + System.lineSeparator() +
				"5 13" + System.lineSeparator() +
				"8 3" + System.lineSeparator() +
				"8" + System.lineSeparator() +
				"8 6 2" + System.lineSeparator() +
				"9 7 85" + System.lineSeparator() +
				"6 9 3" + System.lineSeparator() +
				"6 7 5" + System.lineSeparator() +
				"10 3 1" + System.lineSeparator() +
				"12 9 4" + System.lineSeparator() +
				"9 6 6" + System.lineSeparator() +
				"8 2 3";
		String output = "1" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"6" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"3";

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
