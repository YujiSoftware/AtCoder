import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3 1" + System.lineSeparator() +
				"1 2";
		String output = "7";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "7 5" + System.lineSeparator() +
				"1 2" + System.lineSeparator() +
				"3 4" + System.lineSeparator() +
				"3 5" + System.lineSeparator() +
				"4 5" + System.lineSeparator() +
				"2 6";
		String output = "18";

		assertIO(input, output);
	}

	@Test
	public void 入力例_MAX() throws Exception {
		StringBuilder input = new StringBuilder();
		input.append("100000 200000" + System.lineSeparator());
		for (int i = 1; i <= 100000; i++) {
			for (int j = 1; j <= 2; j++) {
				input.append(i).append(' ').append(j).append(System.lineSeparator());
			}
		}

		String output = "18";

		assertIO(input.toString(), output);
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
