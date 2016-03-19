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
			"MinnnahaNakayoshi" + System.lineSeparator() +
				"0 6 8 17";
		String output =
			"\"Minnna\"ha\"Nakayoshi\"";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"Niwawo_Kakemeguru_Chokudai" + System.lineSeparator() +
				"11 17 18 26";
		String output =
			"Niwawo_Kake\"meguru\"_\"Chokudai\"";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input =
			"___" + System.lineSeparator() +
				"0 1 2 3";
		String output =
			"\"_\"_\"_\"";

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