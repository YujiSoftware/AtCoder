import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3" + System.lineSeparator() +
				"abc" + System.lineSeparator() +
				"cde";
		String output = "5";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "1" + System.lineSeparator() +
				"a" + System.lineSeparator() +
				"z";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "4" + System.lineSeparator() +
				"expr" + System.lineSeparator() +
				"expr";
		String output = "4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "4" + System.lineSeparator() +
				"xabc" + System.lineSeparator() +
				"yabc";
		String output = "8";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "4" + System.lineSeparator() +
				"abcx" + System.lineSeparator() +
				"abcy";
		String output = "8";

		assertIO(input, output);
	}

	@Test
	public void 入力例_6() throws Exception {
		String input = "4" + System.lineSeparator() +
				"aaaa" + System.lineSeparator() +
				"aabc";
		String output = "6";

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
