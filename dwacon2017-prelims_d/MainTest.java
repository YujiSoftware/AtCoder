import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "4 1" + System.lineSeparator() +
				"5 2" + System.lineSeparator() +
				"5 3" + System.lineSeparator() +
				"100 50" + System.lineSeparator() +
				"5 1";
		String output = "105";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "5 2" + System.lineSeparator() +
				"5 2" + System.lineSeparator() +
				"100 50" + System.lineSeparator() +
				"5 3" + System.lineSeparator() +
				"5 1" + System.lineSeparator() +
				"100 3";
		String output = "206";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "4 5" + System.lineSeparator() +
				"280 101" + System.lineSeparator() +
				"456 404" + System.lineSeparator() +
				"789 707" + System.lineSeparator() +
				"1000 999";
		String output = "2525";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "4 3" + System.lineSeparator() +
				"280 101" + System.lineSeparator() +
				"456 404" + System.lineSeparator() +
				"789 707" + System.lineSeparator() +
				"1000 999";
		String output = "2346";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "5 1" + System.lineSeparator() +
				"5 2" + System.lineSeparator() +
				"100 50" + System.lineSeparator() +
				"5 3" + System.lineSeparator() +
				"5 1" + System.lineSeparator() +
				"100 3";
		String output = "156";

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
