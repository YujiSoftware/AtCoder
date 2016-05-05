import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "2" + System.lineSeparator() +
			"37 54 68 66 802" + System.lineSeparator() +
			"58 108 106 103 871";
		String output = "481.4555555555555555";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "2" + System.lineSeparator() +
			"80 120 120 120 900" + System.lineSeparator() +
			"0 0 0 0 731";
		String output = "550";

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
