import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "AtCoder Beginner Contest";
		String output = "ABC";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "AtCoder Snuke Contest";
		String output = "ASC";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "AtCoder X Contest";
		String output = "AXC";

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
