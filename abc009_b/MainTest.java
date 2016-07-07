import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "4" + System.lineSeparator() +
				"100" + System.lineSeparator() +
				"200" + System.lineSeparator() +
				"300" + System.lineSeparator() +
				"300";
		String output = "200";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "5" + System.lineSeparator() +
				"50" + System.lineSeparator() +
				"370" + System.lineSeparator() +
				"819" + System.lineSeparator() +
				"433" + System.lineSeparator() +
				"120";
		String output = "433";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "6" + System.lineSeparator() +
				"100" + System.lineSeparator() +
				"100" + System.lineSeparator() +
				"100" + System.lineSeparator() +
				"200" + System.lineSeparator() +
				"200" + System.lineSeparator() +
				"200";
		String output = "100";

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
