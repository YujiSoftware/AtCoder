import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "5" + System.lineSeparator() +
				"1 2 1" + System.lineSeparator() +
				"1 3 1" + System.lineSeparator() +
				"2 4 1" + System.lineSeparator() +
				"3 5 1" + System.lineSeparator() +
				"3 1" + System.lineSeparator() +
				"2 4" + System.lineSeparator() +
				"2 3" + System.lineSeparator() +
				"4 5";
		String output = "3" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "7" + System.lineSeparator() +
				"1 2 1" + System.lineSeparator() +
				"1 3 3" + System.lineSeparator() +
				"1 4 5" + System.lineSeparator() +
				"1 5 7" + System.lineSeparator() +
				"1 6 9" + System.lineSeparator() +
				"1 7 11" + System.lineSeparator() +
				"3 2" + System.lineSeparator() +
				"1 3" + System.lineSeparator() +
				"4 5" + System.lineSeparator() +
				"6 7";
		String output = "5" + System.lineSeparator() +
				"14" + System.lineSeparator() +
				"22";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "10" + System.lineSeparator() +
				"1 2 1000000000" + System.lineSeparator() +
				"2 3 1000000000" + System.lineSeparator() +
				"3 4 1000000000" + System.lineSeparator() +
				"4 5 1000000000" + System.lineSeparator() +
				"5 6 1000000000" + System.lineSeparator() +
				"6 7 1000000000" + System.lineSeparator() +
				"7 8 1000000000" + System.lineSeparator() +
				"8 9 1000000000" + System.lineSeparator() +
				"9 10 1000000000" + System.lineSeparator() +
				"1 1" + System.lineSeparator() +
				"9 10";
		String output = "17000000000";

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
