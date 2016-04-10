import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "7 8" + System.lineSeparator()
			+ "2 2" + System.lineSeparator()
			+ "4 5" + System.lineSeparator()
			+ "########" + System.lineSeparator()
			+ "#......#" + System.lineSeparator()
			+ "#.######" + System.lineSeparator()
			+ "#..#...#" + System.lineSeparator()
			+ "#..##..#" + System.lineSeparator()
			+ "##.....#" + System.lineSeparator()
			+ "########";
		String output = "11";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "5 8" + System.lineSeparator()
			+ "2 2" + System.lineSeparator()
			+ "2 4" + System.lineSeparator()
			+ "########" + System.lineSeparator()
			+ "#.#....#" + System.lineSeparator()
			+ "#.###..#" + System.lineSeparator()
			+ "#......#" + System.lineSeparator()
			+ "########";
		String output = "10";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "50 50" + System.lineSeparator()
			+ "2 2" + System.lineSeparator()
			+ "49 49" + System.lineSeparator()
			+ "##################################################" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "#................................................#" + System.lineSeparator()
			+ "##################################################";
		String output = "94";

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
