import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "5" + System.lineSeparator() +
				"chokudai" + System.lineSeparator() +
				"kensho" + System.lineSeparator() +
				"imos" + System.lineSeparator() +
				"yuichirw" + System.lineSeparator() +
				"ao";
		String output = "chokudai" + System.lineSeparator() +
				"ao" + System.lineSeparator() +
				"kensho" + System.lineSeparator() +
				"imos" + System.lineSeparator() +
				"yuichirw";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "2" + System.lineSeparator() +
				"dart" + System.lineSeparator() +
				"art";
		String output = "art" + System.lineSeparator() +
				"dart";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "3" + System.lineSeparator() +
				"apple" + System.lineSeparator() +
				"bee" + System.lineSeparator() +
				"card";
		String output = "card" + System.lineSeparator() +
				"bee" + System.lineSeparator() +
				"apple";

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
