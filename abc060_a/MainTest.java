import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "rng gorilla apple";
		String output = "YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "yakiniku unagi sushi";
		String output = "NO";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "a a a";
		String output = "YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "aaaaaaaaab aaaaaaaaaa aaaaaaaaab";
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
