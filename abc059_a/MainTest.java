import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "4" + System.lineSeparator() +
				"1 -3 1 0";
		String output = "4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "5" + System.lineSeparator() +
				"3 -6 4 -5 7";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "6" + System.lineSeparator() +
				"-1 4 3 2 -5 4";
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
