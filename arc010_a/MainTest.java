import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "100 3 0 100" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"20" + System.lineSeparator() +
				"30";
		String output = "complete";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "100 4 0 100" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"20" + System.lineSeparator() +
				"30" + System.lineSeparator() +
				"40";
		String output = "complete";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "100 4 0 100" + System.lineSeparator() +
				"50" + System.lineSeparator() +
				"40" + System.lineSeparator() +
				"30" + System.lineSeparator() +
				"20";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "100 4 10 100" + System.lineSeparator() +
				"50" + System.lineSeparator() +
				"40" + System.lineSeparator() +
				"30" + System.lineSeparator() +
				"20";
		String output = "complete";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "5 3 20 10" + System.lineSeparator() +
				"15" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"20";
		String output = "3";

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
