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
			"5 10" + System.lineSeparator() +
				"20" + System.lineSeparator() +
				"100" + System.lineSeparator() +
				"105" + System.lineSeparator() +
				"217" + System.lineSeparator() +
				"314";
		String output =
			"45";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"10 10" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"6" + System.lineSeparator() +
				"7" + System.lineSeparator() +
				"8" + System.lineSeparator() +
				"9" + System.lineSeparator() +
				"10";
		String output =
			"19";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input =
			"10 100000" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"31" + System.lineSeparator() +
				"314" + System.lineSeparator() +
				"3141" + System.lineSeparator() +
				"31415" + System.lineSeparator() +
				"314159" + System.lineSeparator() +
				"400000" + System.lineSeparator() +
				"410000" + System.lineSeparator() +
				"500000" + System.lineSeparator() +
				"777777";
		String output =
			"517253";

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
