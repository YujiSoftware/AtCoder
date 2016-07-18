import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "6" + System.lineSeparator() +
				"2 1" + System.lineSeparator() +
				"2 2" + System.lineSeparator() +
				"3 2" + System.lineSeparator() +
				"5 3" + System.lineSeparator() +
				"2 2" + System.lineSeparator() +
				"3 3";
		String output = "2 3 0" + System.lineSeparator() +
				"0 4 1" + System.lineSeparator() +
				"4 1 0" + System.lineSeparator() +
				"5 0 0" + System.lineSeparator() +
				"0 4 1" + System.lineSeparator() +
				"3 2 0";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "2" + System.lineSeparator() +
				"1999 3" + System.lineSeparator() +
				"2000 1";
		String output = "0 1 0" + System.lineSeparator() +
				"1 0 0";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "8" + System.lineSeparator() +
				"3200 2" + System.lineSeparator() +
				"2800 3" + System.lineSeparator() +
				"2800 2" + System.lineSeparator() +
				"2700 1" + System.lineSeparator() +
				"2800 2" + System.lineSeparator() +
				"3200 1" + System.lineSeparator() +
				"2700 1" + System.lineSeparator() +
				"3200 3";
		String output = "6 1 0" + System.lineSeparator() +
				"2 5 0" + System.lineSeparator() +
				"3 3 1" + System.lineSeparator() +
				"0 6 1" + System.lineSeparator() +
				"3 3 1" + System.lineSeparator() +
				"6 1 0" + System.lineSeparator() +
				"0 6 1" + System.lineSeparator() +
				"6 1 0";

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
