import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "atcoder" + System.lineSeparator() +
				"3";
		String output = "c";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "beginner" + System.lineSeparator() +
				"1";
		String output = "b";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "contest" + System.lineSeparator() +
				"7";
		String output = "t";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "z" + System.lineSeparator() +
				"1";
		String output = "z";

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
