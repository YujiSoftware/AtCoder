import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "-1 -1 2" + System.lineSeparator() +
			"2 3 4 5";
		String output = "YES" + System.lineSeparator() +
			"YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "0 1 1" + System.lineSeparator() +
			"-2 0 4 3";
		String output = "NO" + System.lineSeparator() +
			"YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "0 0 5" + System.lineSeparator() +
			"-2 -2 2 1";
		String output = "YES" + System.lineSeparator() +
			"NO";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "0 0 2" + System.lineSeparator() +
			"0 0 4 4";
		String output = "YES" + System.lineSeparator() +
			"YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例5() throws Exception {
		String input = "0 0 5" + System.lineSeparator() +
			"-4 -4 4 4";
		String output = "YES" + System.lineSeparator() +
			"YES";

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
