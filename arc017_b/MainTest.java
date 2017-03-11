import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例１() throws Exception {
		String input = "10 4" + System.lineSeparator() +
				"100" + System.lineSeparator() +
				"300" + System.lineSeparator() +
				"600" + System.lineSeparator() +
				"700" + System.lineSeparator() +
				"800" + System.lineSeparator() +
				"400" + System.lineSeparator() +
				"500" + System.lineSeparator() +
				"800" + System.lineSeparator() +
				"900" + System.lineSeparator() +
				"900";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 入力例２() throws Exception {
		String input = "10 3" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"40" + System.lineSeparator() +
				"50" + System.lineSeparator() +
				"80" + System.lineSeparator() +
				"90" + System.lineSeparator() +
				"30" + System.lineSeparator() +
				"20" + System.lineSeparator() +
				"40" + System.lineSeparator() +
				"90" + System.lineSeparator() +
				"95";
		String output = "5";

		assertIO(input, output);
	}

	@Test
	public void 入力例３() throws Exception {
		String input = "8 4" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"6" + System.lineSeparator() +
				"7" + System.lineSeparator() +
				"8";
		String output = "5";

		assertIO(input, output);
	}

	@Test
	public void 入力例４() throws Exception {
		String input = "8 2" + System.lineSeparator() +
				"100000" + System.lineSeparator() +
				"90000" + System.lineSeparator() +
				"50000" + System.lineSeparator() +
				"30000" + System.lineSeparator() +
				"10000" + System.lineSeparator() +
				"4000" + System.lineSeparator() +
				"200" + System.lineSeparator() +
				"1";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_FULL() throws Exception {
		String input = "8 1" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"6" + System.lineSeparator() +
				"7" + System.lineSeparator() +
				"8";
		String output = "8";

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
