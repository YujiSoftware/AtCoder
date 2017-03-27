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
				"Mozart plays magic.";
		String output = "7003 756 791";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "3" + System.lineSeparator() +
				"Columbus found USA.";
		String output = "15716 492 6";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "7" + System.lineSeparator() +
				"I have a scissors for right hand.";
		String output = "85 616606 40 0983 892";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "4" + System.lineSeparator() +
				"abc ab aa aiueo";
		String output = "11 1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "4" + System.lineSeparator() +
				"aaa aa a aa";
		String output = "";

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
