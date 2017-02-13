import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例１() throws Exception {
		String input = "17";
		String output = "YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例２() throws Exception {
		String input = "18";
		String output = "NO";

		assertIO(input, output);
	}

	@Test
	public void 入力例３() throws Exception {
		String input = "999983";
		String output = "YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例４() throws Exception {
		String input = "672263";
		String output = "NO";

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
