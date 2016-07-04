import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "2 3 4";
		String output = "24";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "10000 1000 100";
		String output = "1000000000";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "100000 1 100000";
		String output = "999999937";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "1000000000 1000000000 1000000000";
		String output = "999999664";

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
