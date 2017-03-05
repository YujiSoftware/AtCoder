import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3 2" + System.lineSeparator() +
				"1 2" + System.lineSeparator() +
				"abc" + System.lineSeparator() +
				"ab" + System.lineSeparator() +
				"a";
		String output = "ab";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "3 2" + System.lineSeparator() +
				"1 2" + System.lineSeparator() +
				"abc" + System.lineSeparator() +
				"ab" + System.lineSeparator() +
				"abc";
		String output = "-1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "3 3" + System.lineSeparator() +
				"1 2 3" + System.lineSeparator() +
				"abc" + System.lineSeparator() +
				"ab" + System.lineSeparator() +
				"abc";
		String output = "";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "5 3" + System.lineSeparator() +
				"1 2 3" + System.lineSeparator() +
				"abcd" + System.lineSeparator() +
				"abcde" + System.lineSeparator() +
				"abc" + System.lineSeparator() +
				"e" + System.lineSeparator() +
				"f";
		String output = "a";

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
