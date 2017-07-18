import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "5 3" + System.lineSeparator() +
				"1 2 3 4 5";
		String output = "12";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "15 14" + System.lineSeparator() +
				"50 26 27 21 41 7 42 35 7 5 5 36 39 1 45";
		String output = "386";

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
