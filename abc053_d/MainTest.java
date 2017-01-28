import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "5" + System.lineSeparator() +
				"1 2 1 3 7";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "15" + System.lineSeparator() +
				"1 3 5 2 1 3 2 8 8 6 2 6 11 1 1";
		String output = "7";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "3" + System.lineSeparator() +
				"1 1 1";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "5" + System.lineSeparator() +
				"1 1 1 1 1";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "7" + System.lineSeparator() +
				"1 1 2 2 2 2 2";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_すべて異なる() throws Exception {
		String input = "3" + System.lineSeparator() +
				"1 2 3";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2つ消える() throws Exception {
		String input = "5" + System.lineSeparator() +
				"1 1 2 3 3";
		String output = "1";

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
