import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "2 3 1 1";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "10 7 3 4";
		String output = "3570";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "100000 100000 99999 99999";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "100000 100000 44444 55555";
		String output = "738162020";

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
