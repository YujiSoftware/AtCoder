import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "5" + System.lineSeparator() +
			"1 2 3 2 1";
		String output = "8";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "4" + System.lineSeparator() +
			"1 2 3 4";
		String output = "10";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "6" + System.lineSeparator() +
			"3 3 4 1 2 2";
		String output = "8";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "6" + System.lineSeparator() +
			"1 5 2 3 4 2";
		String output = "10";

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
