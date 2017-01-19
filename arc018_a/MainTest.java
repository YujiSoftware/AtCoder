import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例１() throws Exception {
		String input = "160.0 23.5";
		String output = "60.160";

		assertIO(input, output);
	}

	@Test
	public void 入力例２() throws Exception {
		String input = "199.9 11.1";
		String output = "44.356";

		assertIO(input, output);
	}

	private void assertIO(String input, String output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		assertEquals(Double.parseDouble(out.toString()), Double.parseDouble(output), 1);
	}
}
