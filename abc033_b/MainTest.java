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
			"4" + System.lineSeparator() +
				"unagi 20" + System.lineSeparator() +
				"usagi 13" + System.lineSeparator() +
				"snuke 42" + System.lineSeparator() +
				"smeke 7";
		String output =
			"snuke";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input =
			"5" + System.lineSeparator() +
				"a 10" + System.lineSeparator() +
				"b 20" + System.lineSeparator() +
				"c 30" + System.lineSeparator() +
				"d 40" + System.lineSeparator() +
				"e 100";
		String output =
			"atcoder";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input =
			"14" + System.lineSeparator() +
				"yasuzuka 3340" + System.lineSeparator() +
				"uragawara 4032" + System.lineSeparator() +
				"oshima 2249" + System.lineSeparator() +
				"maki 2614" + System.lineSeparator() +
				"kakizaki 11484" + System.lineSeparator() +
				"ogata 10401" + System.lineSeparator() +
				"kubiki 9746" + System.lineSeparator() +
				"yoshikawa 5142" + System.lineSeparator() +
				"joetsu 100000" + System.lineSeparator() +
				"nakago 4733" + System.lineSeparator() +
				"itakura 7517" + System.lineSeparator() +
				"kiyosato 3152" + System.lineSeparator() +
				"sanwa 6190" + System.lineSeparator() +
				"nadachi 3169";
		String output =
			"joetsu";

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
