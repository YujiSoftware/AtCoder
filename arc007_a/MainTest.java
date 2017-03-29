import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "a" + System.lineSeparator() +
				"abcdefgabcdefg";
		String output = "bcdefgbcdefg";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "g" + System.lineSeparator() +
				"aassddffgg";
		String output = "aassddff";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "a" + System.lineSeparator() +
				"aaaaa";
		String output = "";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "l" + System.lineSeparator() +
				"qwertyuiopasdfghjklzxcvbnm";
		String output = "qwertyuiopasdfghjkzxcvbnm";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "d" + System.lineSeparator() +
				"qwsdtgcszddddsdfgvbbnj";
		String output = "qwstgcszsfgvbbnj";

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
