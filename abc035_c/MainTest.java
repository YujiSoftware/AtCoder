import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "5 4" + System.lineSeparator() +
			"1 4" + System.lineSeparator() +
			"2 5" + System.lineSeparator() +
			"3 3" + System.lineSeparator() +
			"1 5";
		String output = "01010";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "20 8" + System.lineSeparator() +
			"1 8" + System.lineSeparator() +
			"4 13" + System.lineSeparator() +
			"8 8" + System.lineSeparator() +
			"3 18" + System.lineSeparator() +
			"5 20" + System.lineSeparator() +
			"19 20" + System.lineSeparator() +
			"2 7" + System.lineSeparator() +
			"4 9";
		String output = "10110000011110000000";

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
