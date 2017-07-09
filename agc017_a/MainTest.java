import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "2 0" + System.lineSeparator() +
				"1 3";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "1 1" + System.lineSeparator() +
				"50";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "3 0" + System.lineSeparator() +
				"1 1 1";
		String output = "4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "45 1" + System.lineSeparator() +
				"17 55 85 55 74 20 90 67 40 70 39 89 91 50 16 24 14 43 24 66 25 9 89 71 41 16 53 13 61 15 85 72 62 67 42 26 36 66 4 87 59 91 4 25 26";
		String output = "17592186044416";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "5 1" + System.lineSeparator() +
				"1 2 3 4 5";
		String output = "16";

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
