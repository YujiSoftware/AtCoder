import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3" + System.lineSeparator() +
				"2 3" + System.lineSeparator() +
				"1 1" + System.lineSeparator() +
				"3 2";
		String output = "10";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "4" + System.lineSeparator() +
				"1 1" + System.lineSeparator() +
				"1 1" + System.lineSeparator() +
				"1 5" + System.lineSeparator() +
				"1 100";
		String output = "101";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "5" + System.lineSeparator() +
				"3 10" + System.lineSeparator() +
				"48 17" + System.lineSeparator() +
				"31 199" + System.lineSeparator() +
				"231 23" + System.lineSeparator() +
				"3 2";
		String output = "6930";

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
