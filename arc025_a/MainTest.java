import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "4 2 0 5 6 2 5" + System.lineSeparator() +
				"6 1 4 3 6 4 6";
		String output = "33";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "1 2 3 4 5 6 7" + System.lineSeparator() +
				"2 3 4 5 6 7 8";
		String output = "35";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "0 0 0 0 0 0 0" + System.lineSeparator() +
				"0 0 0 0 0 0 0";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "8 3 0 2 5 25 252" + System.lineSeparator() +
				"252 252 2 5 2 5 2";
		String output = "793";

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
