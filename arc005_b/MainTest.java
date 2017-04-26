import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "3 5 R" + System.lineSeparator() +
				"790319030" + System.lineSeparator() +
				"091076399" + System.lineSeparator() +
				"143245946" + System.lineSeparator() +
				"590051196" + System.lineSeparator() +
				"398226115" + System.lineSeparator() +
				"442567154" + System.lineSeparator() +
				"112705290" + System.lineSeparator() +
				"716433235" + System.lineSeparator() +
				"221041645";
		String output = "8226";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "8 9 LU" + System.lineSeparator() +
				"206932999" + System.lineSeparator() +
				"471100777" + System.lineSeparator() +
				"973172688" + System.lineSeparator() +
				"108989704" + System.lineSeparator() +
				"246954192" + System.lineSeparator() +
				"399039569" + System.lineSeparator() +
				"944715218" + System.lineSeparator() +
				"003664867" + System.lineSeparator() +
				"219006823";
		String output = "2853";

		assertIO(input, output);
	}

	@Test
	public void 入力例_3() throws Exception {
		String input = "5 7 D" + System.lineSeparator() +
				"271573743" + System.lineSeparator() +
				"915078603" + System.lineSeparator() +
				"102553534" + System.lineSeparator() +
				"996473623" + System.lineSeparator() +
				"595593497" + System.lineSeparator() +
				"573572507" + System.lineSeparator() +
				"340348994" + System.lineSeparator() +
				"253066837" + System.lineSeparator() +
				"643845096";
		String output = "4646";

		assertIO(input, output);
	}

	@Test
	public void 入力例_4() throws Exception {
		String input = "2 2 LU" + System.lineSeparator() +
				"729142134" + System.lineSeparator() +
				"509607882" + System.lineSeparator() +
				"640003027" + System.lineSeparator() +
				"215270061" + System.lineSeparator() +
				"214055727" + System.lineSeparator() +
				"745319402" + System.lineSeparator() +
				"777708131" + System.lineSeparator() +
				"018697986" + System.lineSeparator() +
				"277156993";
		String output = "0700";

		assertIO(input, output);
	}

	@Test
	public void 入力例_5() throws Exception {
		String input = "8 7 RD" + System.lineSeparator() +
				"985877833" + System.lineSeparator() +
				"469488482" + System.lineSeparator() +
				"218647263" + System.lineSeparator() +
				"856777094" + System.lineSeparator() +
				"012249580" + System.lineSeparator() +
				"845463670" + System.lineSeparator() +
				"919136580" + System.lineSeparator() +
				"011130808" + System.lineSeparator() +
				"874387671";
		String output = "8878";

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
