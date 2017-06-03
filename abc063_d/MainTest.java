import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "4 5 3" + System.lineSeparator() +
				"8" + System.lineSeparator() +
				"7" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"2";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "2 10 4" + System.lineSeparator() +
				"20" + System.lineSeparator() +
				"20";
		String output = "4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "5 2 1" + System.lineSeparator() +
				"900000000" + System.lineSeparator() +
				"900000000" + System.lineSeparator() +
				"1000000000" + System.lineSeparator() +
				"1000000000" + System.lineSeparator() +
				"1000000000";
		String output = "800000000";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "5 2 1" + System.lineSeparator() +
				"9" + System.lineSeparator() +
				"9" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"10";
		String output = "8";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "5 2 1" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"1000000000";
		String output = "500000000";

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
