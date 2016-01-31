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
			"50 7" + System.lineSeparator() +
				"40 8" + System.lineSeparator() +
				"30 9";
		String output =
			"94";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"990 10" + System.lineSeparator() +
				"990 10" + System.lineSeparator() +
				"990 10";
		String output =
			"2970";

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
