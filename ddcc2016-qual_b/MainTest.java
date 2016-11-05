import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "1 4 1";
		String output = "7.4641016151377546";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "40 37 5";
		String output = "2712.5411572217257024";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "100000 100000 1000";
		String output = "15907959408.6441142940893769";

		assertIO(input, output);
	}

	private void assertIO(String input, String output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		assertEquals(
				Double.parseDouble(out.toString()),
				Double.parseDouble(output),
				0.000001);

		// Assert.assertThat(out.toString(), is(output +
		// System.lineSeparator()));
	}
}
