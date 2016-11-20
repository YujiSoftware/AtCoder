import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "4 4 2" + System.lineSeparator() +
				"3413" + System.lineSeparator() +
				"4121" + System.lineSeparator() +
				"1424" + System.lineSeparator() +
				"2312";
		String output = "23";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "4 4 2" + System.lineSeparator() +
				"1212" + System.lineSeparator() +
				"2121" + System.lineSeparator() +
				"1212" + System.lineSeparator() +
				"2121";
		String output = "54";

		assertIO(input, output);
	}

	@Test
	public void 入力例3() throws Exception {
		String input = "7 7 2" + System.lineSeparator() +
				"8989898" + System.lineSeparator() +
				"9898989" + System.lineSeparator() +
				"8989898" + System.lineSeparator() +
				"9898989" + System.lineSeparator() +
				"8989898" + System.lineSeparator() +
				"9898989" + System.lineSeparator() +
				"8989898" + System.lineSeparator() +
				"9898989";
		String output = "2520";

		assertIO(input, output);
	}

	@Test
	public void 入力例4() throws Exception {
		String input = "17 17 2" + System.lineSeparator() +
				"12345678912345678" + System.lineSeparator() +
				"23456789123456789" + System.lineSeparator() +
				"34567891234567891" + System.lineSeparator() +
				"45678912345678912" + System.lineSeparator() +
				"56789123456789123" + System.lineSeparator() +
				"67891234567891234" + System.lineSeparator() +
				"78912345678912345" + System.lineSeparator() +
				"89123456789123456" + System.lineSeparator() +
				"91234567891234567" + System.lineSeparator() +
				"12345678912345678" + System.lineSeparator() +
				"23456789123456789" + System.lineSeparator() +
				"34567891234567891" + System.lineSeparator() +
				"45678912345678912" + System.lineSeparator() +
				"56789123456789123" + System.lineSeparator() +
				"67891234567891234" + System.lineSeparator() +
				"78912345678912345" + System.lineSeparator() +
				"89123456789123456";
		String output = "2354638";

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
