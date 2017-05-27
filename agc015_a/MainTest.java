import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "4 4 6";
		String output = "5";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "5 4 3";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "1 7 10";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "1 3 3";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "2 3 3";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_6() throws Exception {
		String input = "2 3 4";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_7() throws Exception {
		String input = "2 3 5";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_8() throws Exception {
		String input = "5 3 4";
		String output = "4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_9() throws Exception {
		String input = "5 3 5";
		String output = "7";

		assertIO(input, output);
	}

	@Test
	public void 入力例() throws Exception {
		for (int n = 0; n < 100; n++) {
			for (int a = 0; a < 100; a++) {
				for (int b = 0; b < 100; b++) {
					assertThat(n + "," + a + "," + b, A(n, a, b), is(B(n, a, b)));
				}
			}
		}
	}

	private int A(int N, int A, int B) {
		if (N == 1) {
			if (A == B) {
				return 1;
			} else {
				return 0;
			}
		} else if (B < A) {
			return 0;
		} else {
			return B * (N - 2) - A * (N - 2) + 1;
		}
	}

	private int B(int N, int A, int B) {
		if (A > B) {
			return 0;
		}
		if (A == B) {
			return 1;
		}
		if (N == 1) {
			return 0;
		}
		if (N == 2) {
			return 1;
		}

		return (B - A) * (N - 2) + 1;
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
