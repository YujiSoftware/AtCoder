import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3 3 3";
		String output = "9";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "2 2 4";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "5 3 5";
		String output = "15";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "2 3 5";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "99999999 99999999 99999999";
		String output = Long.toString(99999999L * 99999999L);

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
