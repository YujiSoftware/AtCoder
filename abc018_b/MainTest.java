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
			"abcdef" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"3 5" + System.lineSeparator() +
				"1 4";
		String output =
			"debacf";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"redcoat" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"1 7" + System.lineSeparator() +
				"1 2" + System.lineSeparator() +
				"3 4";
		String output =
			"atcoder";

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
