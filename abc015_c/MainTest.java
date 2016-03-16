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
			"3 4" + System.lineSeparator() +
				"1 3 5 17" + System.lineSeparator() +
				"2 4 2 3" + System.lineSeparator() +
				"1 3 2 9";
		String output =
			"Found";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"5 3" + System.lineSeparator() +
				"89 62 15" + System.lineSeparator() +
				"44 36 17" + System.lineSeparator() +
				"4 24 24" + System.lineSeparator() +
				"25 98 99" + System.lineSeparator() +
				"66 33 57";
		String output =
			"Nothing";

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
