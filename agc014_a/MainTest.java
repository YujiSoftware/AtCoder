import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "4 12 20";
		String output = "3";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "14 14 14";
		String output = "-1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "454 414 444";
		String output = "1";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "1 1 1";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void ALL() throws Exception {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					StringBuilder sb = new StringBuilder();
					sb.append(i).append(" ").append(j).append(" ").append(k);

					ByteArrayInputStream in = new ByteArrayInputStream(sb.toString().getBytes());
					System.setIn(in);

					ByteArrayOutputStream out = new ByteArrayOutputStream();
					System.setOut(new PrintStream(out));

					Main.main(new String[0]);

					if (out.toString().trim().equals("-1")) {
						System.err.println(sb.toString());
					}
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
