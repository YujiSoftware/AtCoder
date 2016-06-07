import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "6 2 3 1 5";
		double output = 0.8000000000;

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "6 2 10 1 5";
		double output = 0.2500000000;

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "6 3 1 5 3";
		double output = 1.0000000000;

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "10 7 7 6 0";
		double output = 0.2857142857;

		assertIO(input, output);
	}

	@Test
	public void 入力例MAX() throws Exception {
		String input = "100000000 100000000 100000000 99999999 99999999";
		double output = 0;

		assertIO(input, output);
	}

	private void assertIO(String input, double output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		assertEquals(output, Double.parseDouble(out.toString()), 0.0000001);
	}
}
