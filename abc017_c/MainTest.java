import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "4 6" + System.lineSeparator() +
			"1 3 30" + System.lineSeparator() +
			"2 3 40" + System.lineSeparator() +
			"3 6 25" + System.lineSeparator() +
			"6 6 10";
		String output = "80";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "2 7" + System.lineSeparator() +
			"1 3 90" + System.lineSeparator() +
			"5 7 90";
		String output = "180";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "1 4" + System.lineSeparator() +
			"1 4 70";
		String output = "0";

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
