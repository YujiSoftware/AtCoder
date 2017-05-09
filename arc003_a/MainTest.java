import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "34" + System.lineSeparator() +
				"ABABAAABACDDDABADFFABABDABFAAABFAA";
		String output = "2.79411764705882";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "5" + System.lineSeparator() +
				"FFFFF";
		String output = "0";

		assertIO(input, output);
	}

	private void assertIO(String input, String output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		assertEquals(Double.parseDouble(output), Double.parseDouble(out.toString()), 1e9);
		// Assert.assertThat(out.toString(), is(output +
		// System.lineSeparator()));
	}
}
