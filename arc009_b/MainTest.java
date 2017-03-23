import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = 
			"0 8 1 3 5 4 9 7 6 2" + System.lineSeparator() +
			"10" + System.lineSeparator() +
			"1" + System.lineSeparator() +
			"2" + System.lineSeparator() +
			"3" + System.lineSeparator() +
			"4" + System.lineSeparator() +
			"5" + System.lineSeparator() +
			"6" + System.lineSeparator() +
			"7" + System.lineSeparator() +
			"8" + System.lineSeparator() +
			"9" + System.lineSeparator() +
			"10";
		String output = 
			"8" + System.lineSeparator() + 
			"1" + System.lineSeparator() + 
			"3" + System.lineSeparator() + 
			"5" + System.lineSeparator() + 
			"4" + System.lineSeparator() + 
			"9" + System.lineSeparator() + 
			"7" + System.lineSeparator() + 
			"6" + System.lineSeparator() + 
			"2" + System.lineSeparator() + 
			"10";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = 
			"0 9 8 7 6 5 4 3 2 1" + System.lineSeparator() +
			"3" + System.lineSeparator() +
			"13467932" + System.lineSeparator() +
			"98738462" + System.lineSeparator() +
			"74392";
		String output = 
			"74392" + System.lineSeparator() + 
			"98738462" + System.lineSeparator() + 
			"13467932";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = 
			"0 1 2 3 4 5 6 7 8 9" + System.lineSeparator() +
			"4" + System.lineSeparator() +
			"643" + System.lineSeparator() +
			"1234" + System.lineSeparator() +
			"43" + System.lineSeparator() +
			"909";
		String output = 
			"43" + System.lineSeparator() + 
			"643" + System.lineSeparator() + 
			"909" + System.lineSeparator() + 
			"1234";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = 
			"0 7 4 3 9 5 6 2 1 8" + System.lineSeparator() +
			"2" + System.lineSeparator() +
			"333" + System.lineSeparator() +
			"333";
		String output = 
			"333" + System.lineSeparator() + 
			"333";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = 
			"0 2 4 6 8 1 3 5 7 9" + System.lineSeparator() +
			"1" + System.lineSeparator() +
			"10";
		String output = 
			"10";

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
