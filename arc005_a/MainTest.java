import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "5" + System.lineSeparator() +
				"Takahashikun is not an eel.";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "5" + System.lineSeparator() +
				"TAKAHASHIKUN loves TAKAHASHIKUN and takahashikun.";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "6" + System.lineSeparator() +
				"He is not takahasikun but Takahashikun.";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "1" + System.lineSeparator() +
				"takahashikunTAKAHASHIKUNtakahashikun.";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "18" + System.lineSeparator() +
				"You should give Kabayaki to Takahashikun on July twenty seventh if you suspect that he is an eel.";
		String output = "1";

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
