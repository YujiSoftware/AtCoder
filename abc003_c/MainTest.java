import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "2 2" + System.lineSeparator() +
				"1000 1500";
		String output = "1000.000000";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "2 1" + System.lineSeparator() +
				"1000 1500";
		String output = "750";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "10 5" + System.lineSeparator() +
				"2604 2281 3204 2264 2200 2650 2229 2461 2439 2211";
		String output = "2820.031250000";

		assertIO(input, output);
	}

	private void assertIO(String input, String output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		assertEquals(Double.parseDouble(output), Double.parseDouble(out.toString()), 0.00006);
	}
}
