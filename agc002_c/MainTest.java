import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "3 50" + System.lineSeparator() +
				"30 20 10";
		String output = "Possible" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "2 21" + System.lineSeparator() +
				"10 10";
		String output = "Impossible";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "5 50" + System.lineSeparator() +
				"10 20 30 40 50";
		String output = "Possible" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"4";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "4 20" + System.lineSeparator() +
				"10 5 10 10";
		String output = "Possible" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"3";

		assertIO(input, output);
	}

	@Test
	public void 入力例5() throws Exception {
		String input = "5 20" + System.lineSeparator() +
				"10 10 10 10 10";
		String output = "Possible" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例6() throws Exception {
		String input = "3 20" + System.lineSeparator() +
				"10 10 10";
		String output = "Possible" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例7() throws Exception {
		String input = "4 20" + System.lineSeparator() +
				"3 10 10 3";
		String output = "Possible" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"2";

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
