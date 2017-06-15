import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "2012/05/02";
		String output = "2013/01/01";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "2020/05/02";
		String output = "2020/05/02";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "2088/02/28";
		String output = "2088/02/29";

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
