import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "4 5 8" + System.lineSeparator() +
				"1 1" + System.lineSeparator() +
				"1 4" + System.lineSeparator() +
				"1 5" + System.lineSeparator() +
				"2 3" + System.lineSeparator() +
				"3 1" + System.lineSeparator() +
				"3 2" + System.lineSeparator() +
				"3 4" + System.lineSeparator() +
				"4 4";
		String output = "0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "10 10 20" + System.lineSeparator() +
				"1 1" + System.lineSeparator() +
				"1 4" + System.lineSeparator() +
				"1 9" + System.lineSeparator() +
				"2 5" + System.lineSeparator() +
				"3 10" + System.lineSeparator() +
				"4 2" + System.lineSeparator() +
				"4 7" + System.lineSeparator() +
				"5 9" + System.lineSeparator() +
				"6 4" + System.lineSeparator() +
				"6 6" + System.lineSeparator() +
				"6 7" + System.lineSeparator() +
				"7 1" + System.lineSeparator() +
				"7 3" + System.lineSeparator() +
				"7 7" + System.lineSeparator() +
				"8 1" + System.lineSeparator() +
				"8 5" + System.lineSeparator() +
				"8 10" + System.lineSeparator() +
				"9 2" + System.lineSeparator() +
				"10 4" + System.lineSeparator() +
				"10 9";
		String output = "4" + System.lineSeparator() +
				"26" + System.lineSeparator() +
				"22" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "1000000000 1000000000 0";
		String output = "999999996000000004" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"0";

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
