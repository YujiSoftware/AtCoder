import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3 5";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "4 5";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "5 5";
		String output = "4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "100000 2";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "100000 100000";
		String output = "50000";

		assertIO(input, output);
	}

	@Test
	public void 入力例_MIN() throws Exception {
		String input = "2 2";
		String output = "1";

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
