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
				"aab" + System.lineSeparator() +
				"ccb";
		String output = "6";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "1" + System.lineSeparator() +
				"Z" + System.lineSeparator() +
				"Z";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2_2() throws Exception {
		String input = "2" + System.lineSeparator() +
				"ZZ" + System.lineSeparator() +
				"AA";
		String output = "6";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "52" + System.lineSeparator() +
				"RvvttdWIyyPPQFFZZssffEEkkaSSDKqcibbeYrhAljCCGGJppHHn" + System.lineSeparator() +
				"RLLwwdWIxxNNQUUXXVVMMooBBaggDKqcimmeYrhAljOOTTJuuzzn";
		String output = "958681902";

		assertIO(input, output);
	}

	@Test
	public void 入力例_HHH() throws Exception {
		String input = "6" + System.lineSeparator() +
				"AACCEE" + System.lineSeparator() +
				"BBDDFF";
		String output = "54";

		assertIO(input, output);
	}

	@Test
	public void 入力例_HHV() throws Exception {
		String input = "5" + System.lineSeparator() +
				"AACCE" + System.lineSeparator() +
				"BBDDE";
		String output = "18";

		assertIO(input, output);
	}

	@Test
	public void 入力例_HVH() throws Exception {
		String input = "5" + System.lineSeparator() +
				"AACDD" + System.lineSeparator() +
				"BBCEE";
		String output = "12";

		assertIO(input, output);
	}

	@Test
	public void 入力例_HVV() throws Exception {
		String input = "4" + System.lineSeparator() +
				"AACD" + System.lineSeparator() +
				"BBCD";
		String output = "12";

		assertIO(input, output);
	}

	@Test
	public void 入力例_VHH() throws Exception {
		String input = "5" + System.lineSeparator() +
				"ABBDD" + System.lineSeparator() +
				"ACCEE";
		String output = "18";

		assertIO(input, output);
	}

	@Test
	public void 入力例_VHV() throws Exception {
		String input = "4" + System.lineSeparator() +
				"ABBD" + System.lineSeparator() +
				"ACCD";
		String output = "6";

		assertIO(input, output);
	}

	@Test
	public void 入力例_VVH() throws Exception {
		String input = "4" + System.lineSeparator() +
				"ABCC" + System.lineSeparator() +
				"ABDD";
		String output = "12";

		assertIO(input, output);
	}

	@Test
	public void 入力例_VVV() throws Exception {
		String input = "3" + System.lineSeparator() +
				"ABC" + System.lineSeparator() +
				"ABC";
		String output = "12";

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
