import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input =
			"4 3" + System.lineSeparator() +
				"5 3 1 2" + System.lineSeparator() +
				"3 2 4";
		String output =
			"264";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input =
			"3 2" + System.lineSeparator() +
				"23 12 9" + System.lineSeparator() +
				"2 3";
		String output =
			"876796540";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input =
			"2 1" + System.lineSeparator() +
				"1000000000 1000000000" + System.lineSeparator() +
				"2";
		String output =
			"625113690";

		assertIO(input, output);
	}

	@Test
	public void 最大() throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append("120000 120000");
		builder.append(System.lineSeparator());

		for (int i = 0; i < 120000; i++) {
			builder.append(1000000000);
			builder.append(" ");
		}
		builder.append(System.lineSeparator());

		for (int i = 0; i < 120000; i++) {
			builder.append(i % 2 == 0 ? 120000 : 1);
			builder.append(" ");
		}
		builder.append(System.lineSeparator());

		String input =
			builder.toString();
		String output =
			"673132797";

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
