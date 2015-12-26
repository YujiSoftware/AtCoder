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
			"100 200 50 20" + System.lineSeparator() +
				"40 10";
		String output =
			"3500";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"400 1000 400 21" + System.lineSeparator() +
				"10 10";
		String output =
			"14000";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input =
			"400 1000 400 20" + System.lineSeparator() +
				"10 10";
		String output =
			"6000";

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
