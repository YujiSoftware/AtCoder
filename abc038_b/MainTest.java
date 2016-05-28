import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "1080 1920" + System.lineSeparator() +
			"1080 1920";
		String output = "YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "1080 1920" + System.lineSeparator() +
			"1920 1080";
		String output = "YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "334 668" + System.lineSeparator() +
			"668 1002";
		String output = "YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "100 200" + System.lineSeparator() +
			"300 150";
		String output = "NO";

		assertIO(input, output);
	}

	@Test
	public void 入力例5() throws Exception {
		String input = "120 120" + System.lineSeparator() +
			"240 240";
		String output = "NO";

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
