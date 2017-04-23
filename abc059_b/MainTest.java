import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "36" + System.lineSeparator() +
				"24";
		String output = "GREATER";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "850" + System.lineSeparator() +
				"3777";
		String output = "LESS";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "9720246" + System.lineSeparator() +
				"22516266";
		String output = "LESS";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "123456789012345678901234567890" + System.lineSeparator() +
				"234567890123456789012345678901";
		String output = "LESS";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "850" + System.lineSeparator() +
				"850";
		String output = "EQUAL";

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
