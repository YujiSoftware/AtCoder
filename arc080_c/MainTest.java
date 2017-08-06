import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3" + System.lineSeparator() +
				"1 10 100";
		String output = "Yes";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "4" + System.lineSeparator() +
				"1 2 3 4";
		String output = "No";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "3" + System.lineSeparator() +
				"1 4 1";
		String output = "Yes";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "2" + System.lineSeparator() +
				"1 1";
		String output = "No";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "6" + System.lineSeparator() +
				"2 7 1 8 2 8";
		String output = "Yes";

		assertIO(input, output);
	}

	@Test
	public void 入力例_6() throws Exception {
		String input = "4" + System.lineSeparator() +
				"1 2 2 2";
		String output = "No";

		assertIO(input, output);
	}

	@Test
	public void 入力例_7() throws Exception {
		String input = "4" + System.lineSeparator() +
				"2 4 2 2";
		String output = "Yes";

		assertIO(input, output);
	}

	@Test
	public void 入力例_ALL() throws Exception {
		int[] pattern = new int[] { 1, 2, 4 };
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < pattern.length; j++) {
				for (int k = 0; k < pattern.length; k++) {
					for (int l = 0; l < pattern.length; l++) {
						StringBuilder input = new StringBuilder();
						input.append(4);
						input.append(System.lineSeparator());
						input.append(pattern[i]);
						input.append(" ");
						input.append(pattern[j]);
						input.append(" ");
						input.append(pattern[k]);
						input.append(" ");
						input.append(pattern[l]);

						ByteArrayInputStream in = new ByteArrayInputStream(input.toString().getBytes());
						System.setIn(in);

						ByteArrayOutputStream out = new ByteArrayOutputStream();
						System.setOut(new PrintStream(out));

						Main.main(new String[0]);

						System.err.print(
								"[" + pattern[i] + "," + pattern[j] + "," + pattern[k] + "," + pattern[l] + "]"
										+ out.toString());
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
