import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		int input = 1;

		assertIO(input);
	}

	@Test
	public void 入力例2() throws Exception {
		int input = 3;

		assertIO(input);
	}

	@Test
	public void 入力例3() throws Exception {
		int input = 12;

		assertIO(input);
	}

	@Test
	public void 入力例() throws Exception {
		for (int i = 1; i <= 40; i++) {
			System.err.println(i);
			assertIO(i);
		}
	}

	private void assertIO(int K) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(Integer.toString(K).getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		Scanner sc = new Scanner(new ByteArrayInputStream(out.toByteArray()));
		long a = sc.nextLong();
		long b = sc.nextLong();

		System.err.println(out.toString());

		Assert.assertTrue(a <= 1_000_000_000);
		Assert.assertTrue(a >= 0);
		Assert.assertTrue(b <= 1_000_000_000);
		Assert.assertTrue(b >= 0);
		Assert.assertThat(new GcdTest(a, b).counter, is(K));
	}

	private static class GcdTest {
		int counter = 0;

		public GcdTest(long a, long b) {
			gcd(a, b);
		}

		private long gcd(long a, long b) {
			if (b == 0) {
				return a;
			}

			counter++;

			return gcd(b, a % b);
		}
	}
}
