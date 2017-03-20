import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "123456789" + System.lineSeparator() +
				"234567891" + System.lineSeparator() +
				"345678912" + System.lineSeparator() +
				"456789123" + System.lineSeparator() +
				"567891234" + System.lineSeparator() +
				"678912345" + System.lineSeparator() +
				"789123456" + System.lineSeparator() +
				"891234567" + System.lineSeparator() +
				"912345678";
		String output = "Yes";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "123456789" + System.lineSeparator() +
				"234567891" + System.lineSeparator() +
				"345678912" + System.lineSeparator() +
				"456789123" + System.lineSeparator() +
				"567891234" + System.lineSeparator() +
				"678912345" + System.lineSeparator() +
				"789123456" + System.lineSeparator() +
				"891234567" + System.lineSeparator() +
				"912345679";
		String output = "No";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "123456789" + System.lineSeparator() +
				"234567891" + System.lineSeparator() +
				"345678912" + System.lineSeparator() +
				"456789123" + System.lineSeparator() +
				"567891234" + System.lineSeparator() +
				"678912345" + System.lineSeparator() +
				"789123456" + System.lineSeparator() +
				"912345678" + System.lineSeparator() +
				"891234567";
		String output = "No";

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
