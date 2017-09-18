import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "1" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"2";
		String output = "4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "2" + System.lineSeparator() +
				"9" + System.lineSeparator() +
				"3 6";
		String output = "12";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "5" + System.lineSeparator() +
				"20" + System.lineSeparator() +
				"11 12 9 17 12";
		String output = "74";

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
