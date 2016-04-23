import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "IOOIIOIOIIOI";
		String output = "9";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "IOIOIIOIOI";
		String output = "9";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "IIOOII";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "IOI";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 入力例5() throws Exception {
		String input = "IOIO";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 失敗1() throws Exception {
		String input = "I";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 失敗2() throws Exception {
		String input = "O";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 失敗3() throws Exception {
		String input = "IO";
		String output = "0";

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
