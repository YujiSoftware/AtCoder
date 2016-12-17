import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "12??567890";
		String output = "4";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "65?5?4?";
		String output = "2";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "314159265358979";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "2???5????";
		String output = "8";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "52";
		String output = "0";

		assertIO(input, output);
	}

	@Test
	public void 入力例_all() throws Exception {
		char[] chars = new char[] { '9', '2', '5', '?' };
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars.length; j++) {
				for (int k = 0; k < chars.length; k++) {
					for (int l = 0; l < chars.length; l++) {
						for (int m = 0; m < chars.length; m++) {
							for (int n = 0; n < chars.length; n++) {
								StringBuilder sb = new StringBuilder(4);
								sb.append(chars[i]);
								sb.append(chars[j]);
								sb.append(chars[k]);
								sb.append(chars[l]);
								sb.append(chars[m]);
								sb.append(chars[n]);

								String input = sb.toString();

								ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
								System.setIn(in);

								ByteArrayOutputStream out = new ByteArrayOutputStream();
								System.setOut(new PrintStream(out));

								Main.main(new String[0]);

								System.err.print(input + "," + out.toString());
							}
						}
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
