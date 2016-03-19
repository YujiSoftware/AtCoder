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
			"2" + System.lineSeparator() +
				"0 0 1" + System.lineSeparator() +
				"10 10 1";
		String output =
			"5.000000000000000";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input =
			"2" + System.lineSeparator() +
				"0 0 1" + System.lineSeparator() +
				"10 10 2";
		String output =
			"6.666666666666667";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input =
			"10" + System.lineSeparator() +
				"-27 -67 10" + System.lineSeparator() +
				"59 13 10" + System.lineSeparator() +
				"14 -15 9" + System.lineSeparator() +
				"-29 -84 7" + System.lineSeparator() +
				"-75 -2 2" + System.lineSeparator() +
				"-12 -74 5" + System.lineSeparator() +
				"77 31 9" + System.lineSeparator() +
				"40 64 8" + System.lineSeparator() +
				"-81 32 1" + System.lineSeparator() +
				"81 26 5";
		String output =
			"582.222222222222222";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input =
			"8" + System.lineSeparator() +
				"-81739 73917 446" + System.lineSeparator() +
				"42230 30484 911" + System.lineSeparator() +
				"79354 -50126 200" + System.lineSeparator() +
				"33440 -47087 651" + System.lineSeparator() +
				"-73 84114 905" + System.lineSeparator() +
				"79222 -53608 713" + System.lineSeparator() +
				"65194 -46284 685" + System.lineSeparator() +
				"81145 40933 47";
		String output =
			"54924095.383189122374461";

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
