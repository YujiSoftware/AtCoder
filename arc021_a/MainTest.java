import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "2 8 2 2" + System.lineSeparator() +
				"32 2 8 8" + System.lineSeparator() +
				"4 64 2 128" + System.lineSeparator() +
				"2 8 4 2";
		String output = "CONTINUE";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "2 4 16 4" + System.lineSeparator() +
				"8 32 128 8" + System.lineSeparator() +
				"2 64 16 2" + System.lineSeparator() +
				"32 4 32 4";
		String output = "GAMEOVER";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "2 4 2 4" + System.lineSeparator() +
				"4 2 4 2" + System.lineSeparator() +
				"2 4 2 4" + System.lineSeparator() +
				"4 2 4 2";
		String output = "GAMEOVER";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "2 4 2 4" + System.lineSeparator() +
				"4 2 4 2" + System.lineSeparator() +
				"2 4 2 4" + System.lineSeparator() +
				"4 2 8 8";
		String output = "CONTINUE";

		assertIO(input, output);
	}

	@Test
	public void 入力例5() throws Exception {
		String input = "2 4 2 4" + System.lineSeparator() +
				"4 2 4 2" + System.lineSeparator() +
				"2 4 2 8" + System.lineSeparator() +
				"4 2 4 8";
		String output = "CONTINUE";

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
