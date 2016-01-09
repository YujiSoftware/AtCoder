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
			"abcabc" + System.lineSeparator() +
				"2";
		String output =
			"3";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"aaaaa" + System.lineSeparator() +
				"1";
		String output =
			"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input =
			"hello" + System.lineSeparator() +
				"10";
		String output =
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
