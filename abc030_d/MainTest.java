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
			"6 4" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"2 3 1 2 6 5";
		String output =
			"3";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"4 1" + System.lineSeparator() +
				"100000000000000000000" + System.lineSeparator() +
				"2 3 4 1";
		String output =
			"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input =
			"8 1" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2 3 4 5 3 2 4 5";
		String output =
			"2";

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
