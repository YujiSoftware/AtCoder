import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "4 5" + System.lineSeparator()
			+ "1 10 100 1000";
		String output = "101";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "20 1048575" + System.lineSeparator()
			+ "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20";
		String output = "210";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "4 0" + System.lineSeparator()
			+ "1000 1000 1000 1000";
		String output = "0";

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
