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
			"5 5 2" + System.lineSeparator() +
				"1 3" + System.lineSeparator() +
				"4 2";
		String output =
			"(2,5)" + System.lineSeparator() +
				"(3,5)" + System.lineSeparator() +
				"(4,5)" + System.lineSeparator() +
				"(5,3)" + System.lineSeparator() +
				"(5,4)" + System.lineSeparator() +
				"(5,5)";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"5 5 5" + System.lineSeparator() +
				"1 1" + System.lineSeparator() +
				"1 3" + System.lineSeparator() +
				"3 3" + System.lineSeparator() +
				"3 4" + System.lineSeparator() +
				"4 3";
		String output =
			"-1";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input =
			"5 5 2" + System.lineSeparator() +
				"3 2" + System.lineSeparator() +
				"4 3";
		String output =
			"-1";

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
