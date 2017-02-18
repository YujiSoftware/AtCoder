import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "6" + System.lineSeparator() +
				"ooxoox";
		String output = "SSSWWS";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "3" + System.lineSeparator() +
				"oox";
		String output = "-1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "10" + System.lineSeparator() +
				"oxooxoxoox";
		String output = "SSWWSSSWWS";

		assertIO(input, output);
	}

	@Test
	public void 入力例_MAX() throws Exception {
		int length = 100000;
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append('o');
		}

		String input = length + System.lineSeparator() + sb.toString();
		StringBuilder output = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			output.append('S');
		}

		assertIO(input, output.toString());
	}

	private void assertIO(String input, String output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		if (output.startsWith("-1")) {
			Assert.assertThat(out.toString(), is(output + System.lineSeparator()));
			return;
		}

		String actual = out.toString().trim();
		for (int i = 0; i < actual.length(); i++) {
			int left = (i - 1 == -1) ? actual.length() - 1 : i - 1;
			int center = i;
			int right = (i + 1 == actual.length()) ? 0 : i + 1;
			if (input.charAt(i) == 'o') {
				if (actual.charAt(center) == 'S') {
					Assert.assertTrue(actual, actual.charAt(left) == actual.charAt(right));
				} else if (actual.charAt(center) == 'W') {
					Assert.assertTrue(actual, actual.charAt(left) != actual.charAt(right));
				}
			} else {
				if (actual.charAt(center) == 'W') {
					Assert.assertTrue(actual, actual.charAt(left) != actual.charAt(right));
				} else if (actual.charAt(center) == 'S') {
					Assert.assertTrue(actual, actual.charAt(left) == actual.charAt(right));
				}
			}
		}
	}
}
