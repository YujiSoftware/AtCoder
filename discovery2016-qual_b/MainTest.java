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
			"5" + System.lineSeparator() +
				"1 4 3 2 5";
		String output =
			"3";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input =
			"5" + System.lineSeparator() +
				"1 2 3 4 5";
		String output =
			"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input =
			"5" + System.lineSeparator() +
				"5 1 2 3 4";
		String output =
			"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input =
			"8" + System.lineSeparator() +
				"1 1 1 2 2 2 3 3";
		String output =
			"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input =
			"3" + System.lineSeparator() +
				"5 4 5";
		String output =
			"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_6() throws Exception {
		String input =
			"3" + System.lineSeparator() +
				"1 1 1";
		String output =
			"1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_7() throws Exception {
		String input =
			"4" + System.lineSeparator() +
				"5 5 4 4";
		String output =
			"2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_8() throws Exception {
		String input =
			"4" + System.lineSeparator() +
				"2 1 3 2 ";
		String output =
			"2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_ALL() throws Exception {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				for (int k = 1; k <= 3; k++) {
					for (int l = 1; l <= 3; l++) {
						String input = String.format("4\r\n%d %d %d %d", i, j, k, l);
						ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
						System.setIn(in);

						ByteArrayOutputStream out = new ByteArrayOutputStream();
						System.setOut(new PrintStream(out));

						Main.main(new String[0]);

						System.err.printf("%d %d %d %d = %s", i, j, k, l, out.toString());
					}
				}
			}
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
