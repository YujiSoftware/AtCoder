import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "4 8 2";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "0 5 1";
		String output = "6";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "9 9 2";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "1 1000000000000000000 3";
		String output = "333333333333333333";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "0 0 1";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_6() throws Exception {
		String input = "1 2 1";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_7() throws Exception {
		String input = "10 10 2";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_9() throws Exception {
		String input = "2 3 2";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_10() throws Exception {
		String input = "0 1000000000000000000 1";
		String output = "1000000000000000001";

		assertIO(input, output);
	}

	@Test
	@Ignore
	public void 入力例_ALL() throws Exception {
		for (int a = 0; a < 100; a++) {
			for (int b = a; b < 100; b++) {
				for (int x = 1; x < 100; x++) {
					String input = a + " " + b + " " + x;
					long output = 0;
					for (int i = a; i <= b; i++) {
						if (i % x == 0) {
							output++;
						}
					}

					try {
						assertIO(input, Long.toString(output));
					} catch (Throwable e) {
						System.err.println(input);
						throw e;
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
