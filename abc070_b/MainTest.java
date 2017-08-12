import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "0 75 25 100";
		String output = "50";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "0 33 66 99";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "10 90 20 80";
		String output = "60";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "10 90 20 40";
		String output = "20";

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
