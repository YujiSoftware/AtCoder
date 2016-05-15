import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "5 2" + System.lineSeparator() +
			"1 3 10" + System.lineSeparator() +
			"2 4 20";
		String output = "10" + System.lineSeparator() +
			"20" + System.lineSeparator() +
			"20" + System.lineSeparator() +
			"20" + System.lineSeparator() +
			"0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "10 4" + System.lineSeparator() +
			"2 7 22" + System.lineSeparator() +
			"3 5 4" + System.lineSeparator() +
			"6 10 1" + System.lineSeparator() +
			"4 4 12";
		String output = "0" + System.lineSeparator() +
			"22" + System.lineSeparator() +
			"4" + System.lineSeparator() +
			"12" + System.lineSeparator() +
			"4" + System.lineSeparator() +
			"1" + System.lineSeparator() +
			"1" + System.lineSeparator() +
			"1" + System.lineSeparator() +
			"1" + System.lineSeparator() +
			"1";

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
