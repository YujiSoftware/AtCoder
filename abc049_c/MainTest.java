import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "erasedream";
		String output = "YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "dreameraser";
		String output = "YES";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "dreamerer";
		String output = "NO";

		assertIO(input, output);
	}

	@Test
	public void 入力例_FULL() throws Exception {
		String[] patterns = new String[] {
				"dreamer",
				"dream",
				"eraser",
				"erase"
		};
		for (String p0 : patterns) {
			for (String p1 : patterns) {
				for (String p2 : patterns) {
					String input = p0 + p1 + p2;
					String output = "YES";

					System.err.println(input);
					assertIO(input, output);
				}
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
