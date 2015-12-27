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
			"5 60 70" + System.lineSeparator() +
				"50" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10";
		String output =
			"2";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"5 50 100" + System.lineSeparator() +
				"120" + System.lineSeparator() +
				"-10" + System.lineSeparator() +
				"-20" + System.lineSeparator() +
				"-30" + System.lineSeparator() +
				"70";
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
