import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input =
			"0+0+2*0";
		String output =
			"0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input =
			"3*1+1*2";
		String output =
			"2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input =
			"3*1*4+0+2*0+5*2+9*8*6+1+3";
		String output =
			"5";

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
