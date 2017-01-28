import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "7";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "149696127901";
		String output = "27217477801";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "22";
		String output = "4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		for (int i = 1; i <= 6; i++) {
			String input = Integer.toString(i);
			String output = "1";

			assertIO(input, output);
		}
	}

	@Test
	public void 入力例5() throws Exception {
		for (int i = 7; i <= 11; i++) {
			String input = Integer.toString(i);
			String output = "2";

			assertIO(input, output);
		}
	}

	@Test
	public void 入力例6() throws Exception {
		for (int i = 12; i <= 17; i++) {
			String input = Integer.toString(i);
			String output = "3";

			assertIO(input, output);
		}
	}

	@Test
	public void 入力例7() throws Exception {
		for (int i = 18; i <= 22; i++) {
			String input = Integer.toString(i);
			String output = "4";

			assertIO(input, output);
		}
	}

	@Test
	public void 入力例8() throws Exception {
		for (int i = 23; i <= 28; i++) {
			String input = Integer.toString(i);
			String output = "5";
			System.err.println(i);

			assertIO(input, output);
		}
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
