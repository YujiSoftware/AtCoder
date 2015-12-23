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
			"3 5 10" + System.lineSeparator() +
				"East 7" + System.lineSeparator() +
				"West 3" + System.lineSeparator() +
				"West 11";
		String output =
			"West 8";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"3 3 8" + System.lineSeparator() +
				"West 6" + System.lineSeparator() +
				"East 3" + System.lineSeparator() +
				"East 1";
		String output =
			"0";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input =
			"5 25 25" + System.lineSeparator() +
				"East 1" + System.lineSeparator() +
				"East 1" + System.lineSeparator() +
				"West 1" + System.lineSeparator() +
				"East 100" + System.lineSeparator() +
				"West 1";
		String output =
			"East 25";

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