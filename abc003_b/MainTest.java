import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "ch@ku@ai" + System.lineSeparator() +
				"choku@@i";
		String output = "You can win";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "aoki" + System.lineSeparator() +
				"@ok@";
		String output = "You will lose";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "arc" + System.lineSeparator() +
				"abc";
		String output = "You will lose";

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
