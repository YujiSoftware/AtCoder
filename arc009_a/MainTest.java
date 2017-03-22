import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "2" + System.lineSeparator() +
				"4 120" + System.lineSeparator() +
				"2 130";
		String output = "777";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "1" + System.lineSeparator() +
				"1 100";
		String output = "105";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "4" + System.lineSeparator() +
				"3 510" + System.lineSeparator() +
				"1 835" + System.lineSeparator() +
				"2 140" + System.lineSeparator() +
				"6 205";
		String output = "4068";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "10" + System.lineSeparator() +
				"8 10" + System.lineSeparator() +
				"7 189" + System.lineSeparator() +
				"4 545" + System.lineSeparator() +
				"1 596" + System.lineSeparator() +
				"3 209" + System.lineSeparator() +
				"10 850" + System.lineSeparator() +
				"9 943" + System.lineSeparator() +
				"6 921" + System.lineSeparator() +
				"8 984" + System.lineSeparator() +
				"10 702";
		String output = "44321";

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
