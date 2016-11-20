import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "7 7";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "6 0";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "18 10";
		String output = "7";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "100 8";
		String output = "45";

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
