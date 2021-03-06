import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "9" + System.lineSeparator() +
				"1 3 6 13 15 18 19 29 31" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"4" + System.lineSeparator() +
				"1 8" + System.lineSeparator() +
				"7 3" + System.lineSeparator() +
				"6 7" + System.lineSeparator() +
				"8 5";
		String output = "4" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "9" + System.lineSeparator() +
				"1 3 6 13 15 18 19 29 31" + System.lineSeparator() +
				"10" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"1 9" + System.lineSeparator() +
				"9 1";
		String output = "5" + System.lineSeparator() +
				"5";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "2" + System.lineSeparator() +
				"1 1000000000" + System.lineSeparator() +
				"1000000000" + System.lineSeparator() +
				"1" + System.lineSeparator() +
				"1 2";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append(100000);
		builder.append(System.lineSeparator());
		builder.append(
				IntStream.rangeClosed(1, 100000)
						.mapToObj(Integer::toString)
						.collect(Collectors.joining(" ")));
		builder.append(System.lineSeparator());
		builder.append(1);
		builder.append(System.lineSeparator());
		builder.append(100000);
		builder.append(System.lineSeparator());
		builder.append(
				IntStream.rangeClosed(1, 100000)
						.mapToObj(i -> "1 100000")
						.collect(Collectors.joining(System.lineSeparator())));

		String input = builder.toString();
		String output = IntStream.rangeClosed(1, 100000)
				.mapToObj(i -> "99999")
				.collect(Collectors.joining(System.lineSeparator()));

		assertIO(input, output);
	}

	@Test
	public void 入力例_subtask2_02() throws Exception {
		String input = new String(Files.readAllBytes(Paths.get("src\\in\\subtask2_02.txt")));
		String output = new String(Files.readAllBytes(Paths.get("src\\out\\subtask2_02.txt")));

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
