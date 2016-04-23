import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "4 5" + System.lineSeparator() +
			"100 4 60 1 4";
		String output = "160";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "10 1" + System.lineSeparator() +
			"5000 2 2000 1 300";
		String output = "20000";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "9 23" + System.lineSeparator() +
			"170 8 120 5 12";
		String output = "650";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "653 314159" + System.lineSeparator() +
			"6728 123456 5141 41928 222222";
		String output = "2818162";

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
