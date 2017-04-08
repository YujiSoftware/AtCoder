import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3 3" + System.lineSeparator() +
				"1 3 4" + System.lineSeparator() +
				"1 3 6";
		String output = "60";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "6 5" + System.lineSeparator() +
				"-790013317 -192321079 95834122 418379342 586260100 802780784" + System.lineSeparator() +
				"-253230108 193944314 363756450 712662868 735867677";
		String output = "835067060";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "4 3" + System.lineSeparator() +
				"-1 0 1 2" + System.lineSeparator() +
				"-1 0 1";
		String output = "40";

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
