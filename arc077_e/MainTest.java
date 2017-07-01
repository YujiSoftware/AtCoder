import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "4 6" + System.lineSeparator() +
				"1 5 1 4";
		String output = "5";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "10 10" + System.lineSeparator() +
				"10 9 8 7 6 5 4 3 2 1";
		String output = "45";

		assertIO(input, output);
	}

	@Test
	public void max() throws Exception {
		String input = "100000 100000" + System.lineSeparator() +
				IntStream.rangeClosed(1, 100000)
						.mapToObj(i -> Integer.toString(i))
						.collect(Collectors.joining(" "));
		String output = "99999";

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
