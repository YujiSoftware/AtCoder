import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = 
			"aabbbaad";
		String output = 
			"a2b3a2d1";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = 
			"aabbbbbbbbbbbbxyza";
		String output = 
			"a2b12x1y1z1a1";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = 
			"edcba";
		String output = 
			"e1d1c1b1a1";

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
