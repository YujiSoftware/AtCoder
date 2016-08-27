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
				"0 1 2" + System.lineSeparator() +
				"3" + System.lineSeparator() +
				"1 2 10" + System.lineSeparator() +
				"1 3 -20" + System.lineSeparator() +
				"2 3 20" + System.lineSeparator() +
				"6" + System.lineSeparator() +
				"1 1 1" + System.lineSeparator() +
				"1 2 1" + System.lineSeparator() +
				"3 3 2" + System.lineSeparator() +
				"1 1 2" + System.lineSeparator() +
				"1 1 3" + System.lineSeparator() +
				"1 3 3";
		String output = "0" + System.lineSeparator() +
				"-10" + System.lineSeparator() +
				"-9" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"-18";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "3" + System.lineSeparator() +
				"454314 -698320 390858" + System.lineSeparator() +
				"7" + System.lineSeparator() +
				"1 3 -916798" + System.lineSeparator() +
				"1 2 -927828" + System.lineSeparator() +
				"2 2 537269" + System.lineSeparator() +
				"1 1 -765412" + System.lineSeparator() +
				"3 3 -299727" + System.lineSeparator() +
				"3 3 250850" + System.lineSeparator() +
				"3 3 526409" + System.lineSeparator() +
				"7" + System.lineSeparator() +
				"3 5 3" + System.lineSeparator() +
				"1 5 1" + System.lineSeparator() +
				"7 7 1" + System.lineSeparator() +
				"6 6 1" + System.lineSeparator() +
				"4 5 3" + System.lineSeparator() +
				"3 6 3" + System.lineSeparator() +
				"6 6 2";
		String output = "-825667" + System.lineSeparator() +
				"-2155724" + System.lineSeparator() +
				"-2155724" + System.lineSeparator() +
				"-2155724" + System.lineSeparator() +
				"-825667" + System.lineSeparator() +
				"-825667" + System.lineSeparator() +
				"-2005677";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "7" + System.lineSeparator() +
				"74567 -876079 911351 746764 -924924 713268 666931" + System.lineSeparator() +
				"7" + System.lineSeparator() +
				"6 7 -318557" + System.lineSeparator() +
				"5 6 -349441" + System.lineSeparator() +
				"2 4 -629716" + System.lineSeparator() +
				"3 7 595329" + System.lineSeparator() +
				"4 7 174594" + System.lineSeparator() +
				"5 5 -948318" + System.lineSeparator() +
				"2 6 -47210" + System.lineSeparator() +
				"8" + System.lineSeparator() +
				"2 4 4" + System.lineSeparator() +
				"1 5 3" + System.lineSeparator() +
				"3 5 5" + System.lineSeparator() +
				"1 3 3" + System.lineSeparator() +
				"4 7 5" + System.lineSeparator() +
				"1 7 1" + System.lineSeparator() +
				"5 5 5" + System.lineSeparator() +
				"6 7 2";
		String output = "117048" + System.lineSeparator() +
				"281635" + System.lineSeparator() +
				"-1274365" + System.lineSeparator() +
				"281635" + System.lineSeparator() +
				"-1499970" + System.lineSeparator() +
				"74567" + System.lineSeparator() +
				"-679036" + System.lineSeparator() +
				"-1553005";

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
