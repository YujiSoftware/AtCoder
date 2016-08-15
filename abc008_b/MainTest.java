import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "4" + System.lineSeparator() +
				"taro" + System.lineSeparator() +
				"jiro" + System.lineSeparator() +
				"taro" + System.lineSeparator() +
				"saburo";
		String output = "taro";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "1" + System.lineSeparator() +
				"takahashikun";
		String output = "takahashikun";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "9" + System.lineSeparator() +
				"a" + System.lineSeparator() +
				"b" + System.lineSeparator() +
				"c" + System.lineSeparator() +
				"c" + System.lineSeparator() +
				"b" + System.lineSeparator() +
				"c" + System.lineSeparator() +
				"b" + System.lineSeparator() +
				"d" + System.lineSeparator() +
				"e";
		String output = "b";

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
