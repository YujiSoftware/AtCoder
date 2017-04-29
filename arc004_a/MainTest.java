import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3" + System.lineSeparator() +
				"1 1" + System.lineSeparator() +
				"2 4" + System.lineSeparator() +
				"4 3";
		String output = "3.605551";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "10" + System.lineSeparator() +
				"1 8" + System.lineSeparator() +
				"4 0" + System.lineSeparator() +
				"3 7" + System.lineSeparator() +
				"2 4" + System.lineSeparator() +
				"5 9" + System.lineSeparator() +
				"9 1" + System.lineSeparator() +
				"6 2" + System.lineSeparator() +
				"0 2" + System.lineSeparator() +
				"8 6" + System.lineSeparator() +
				"7 8";
		String output = "10.630146";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "4" + System.lineSeparator() +
				"0 0" + System.lineSeparator() +
				"0 100" + System.lineSeparator() +
				"100 0" + System.lineSeparator() +
				"100 100";
		String output = "141.421356";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "5" + System.lineSeparator() +
				"3 0" + System.lineSeparator() +
				"1 0" + System.lineSeparator() +
				"0 0" + System.lineSeparator() +
				"4 0" + System.lineSeparator() +
				"2 0";
		String output = "4.000000";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "4" + System.lineSeparator() +
				"2 2" + System.lineSeparator() +
				"0 0" + System.lineSeparator() +
				"1 1" + System.lineSeparator() +
				"3 3";
		String output = "4.242641";

		assertIO(input, output);
	}

	private void assertIO(String input, String output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		assertEquals(Double.parseDouble(output), Double.parseDouble(out.toString()), 0.0001);
	}
}
