import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void ���͗�1() throws Exception {
		String input = 
			"567 234";
		String output = 
			"733";

		assertIO(input, output);
	}

	@Test
	public void ���͗�2() throws Exception {
		String input = 
			"999 100";
		String output = 
			"899";

		assertIO(input, output);
	}

	@Test
	public void ���͗�3() throws Exception {
		String input = 
			"100 999";
		String output = 
			"-99";

		assertIO(input, output);
	}

	@Test
	public void ���͗�4() throws Exception {
		String input = 
			"999 101";
		String output = 
			"899";

		assertIO(input, output);
	}

	@Test
	public void ���͗�5() throws Exception {
		String input = 
			"999 110";
		String output = 
			"899";

		assertIO(input, output);
	}

	@Test
	public void ���͗�6() throws Exception {
		String input = 
			"999 900";
		String output = 
			"899";

		assertIO(input, output);
	}

	@Test
	public void ���͗�8() throws Exception {
		String input = 
			"991 100";
		String output = 
			"899";

		assertIO(input, output);
	}

	@Test
	public void ���͗�9() throws Exception {
		String input = 
			"989 100";
		String output = 
			"899";

		assertIO(input, output);
	}

	@Test
	public void ���͗�10() throws Exception {
		String input = 
			"899 100";
		String output = 
			"899";

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
