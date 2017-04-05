import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "5 6" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"3";
		String output = "0" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "3 5" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2";
		String output = "0" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"3";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "5 0";
		String output = "1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"5";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "10 7" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"8" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"8" + System.lineSeparator() +
				"1";
		String output = "8" + System.lineSeparator() +
				"0" + System.lineSeparator() +
				"5" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"6" + System.lineSeparator() +
				"7" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"9" + System.lineSeparator() +
				"10";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "5 7" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"0";
		String output = "3" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"5";

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
