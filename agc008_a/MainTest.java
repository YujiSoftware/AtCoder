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
		String input = "10 20";
		String output = "10";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "10 -10";
		String output = "1";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "-10 -20";
		String output = "12";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "-10 20";
		String output = "11";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "0 20";
		String output = "20";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_6() throws Exception {
		String input = "10 0";
		String output = "11";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_7() throws Exception {
		String input = "0 0";
		String output = "0";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_8() throws Exception {
		String input = "20 10";
		String output = "12";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_9() throws Exception {
		String input = "-2 1";
		String output = "2";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_10() throws Exception {
		String input = "2 -1";
		String output = "2";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_11() throws Exception {
		String input = "-20 -10";
		String output = "10";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_12() throws Exception {
		String input = "10 10";
		String output = "0";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_13() throws Exception {
		String input = "-10 -10";
		String output = "0";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_14() throws Exception {
		String input = "-2 0";
		String output = "2";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	public void 入力例_15() throws Exception {
		String input = "0 -1";
		String output = "2";
		System.err.print(input + " -> ");

		assertIO(input, output);
	}

	@Test
	@Ignore
	public void 入力例_FULL() throws Exception {
		for (int x = -2; x <= 2; x++) {
			for (int y = -2; y <= 2; y++) {
				String input = x + " " + y;

				ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
				System.setIn(in);

				ByteArrayOutputStream out = new ByteArrayOutputStream();
				System.setOut(new PrintStream(out));

				Main.main(new String[0]);

				System.err.print(input + "->" + out.toString());
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
