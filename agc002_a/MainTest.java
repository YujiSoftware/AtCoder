import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "1 3";
		String output = "Positive";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "-3 -1";
		String output = "Negative";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "-1 1";
		String output = "Zero";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "-1 -1";
		String output = "Negative";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "-2 -1";
		String output = "Positive";

		assertIO(input, output);
	}

	@Test
	public void 入力例_ALL() throws Exception {
		for (int a = -10; a <= 10; a++) {
			for (int b = a; b <= 10; b++) {
				int result = a;
				for (int i = a + 1; i <= b; i++) {
					result *= i;
				}

				String input = a + " " + b;
				String output = result == 0 ? "Zero" : result < 0 ? "Negative" : "Positive";

				System.err.println(input + "=" + output);
				assertIO(input, output);
			}
		}
	}

	@Test
	public void 入力例_Zero1() throws Exception {
		String input = "0 1";
		String output = "Zero";

		assertIO(input, output);
	}

	@Test
	public void 入力例_Zero2() throws Exception {
		String input = "-1 0";
		String output = "Zero";

		assertIO(input, output);
	}

	@Test
	public void 入力例_Zero3() throws Exception {
		String input = "0 0";
		String output = "Zero";

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
