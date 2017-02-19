import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void falldown_test() throws Exception {
		char[][] S = new char[][] {
				new char[] { '.', 'x', '.' },
				new char[] { 'x', 'x', '.' },
				new char[] { '.', 'x', '.' },
				new char[] { '.', 'x', 'x' },
		};
		System.err.println(Main.score(Main.falldown(S)));
	}

	@Test
	public void 入力例_1() throws Exception {
		String input = "o.xx..ox.." + System.lineSeparator() +
				"..o.xx.o.x" + System.lineSeparator() +
				".xxoo...o." + System.lineSeparator() +
				"o..x.ox.x." + System.lineSeparator() +
				"..o.o..ox." + System.lineSeparator() +
				"..x..oo..x" + System.lineSeparator() +
				".o.x.xxo.." + System.lineSeparator() +
				"x..xo.xxoo" + System.lineSeparator() +
				".o..oox..." + System.lineSeparator() +
				"x.o.x.ox.x";
		String output = "o.xx..ox.." + System.lineSeparator() +
				"..o.xx.o+x" + System.lineSeparator() +
				"-xxoo.+.o." + System.lineSeparator() +
				"o..x.ox.x." + System.lineSeparator() +
				"..o.o+.ox." + System.lineSeparator() +
				"..x..oo..x" + System.lineSeparator() +
				".o.x.xxo.." + System.lineSeparator() +
				"x.+xo-xxoo" + System.lineSeparator() +
				".o..oox+++" + System.lineSeparator() +
				"x.o.x.ox.x";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = ".oo...x....xoo.xooooo.xx..xxo..xx.xoox.o..x..oo.o." + System.lineSeparator() +
				"o..ox.xoxxox.xo..ooxx.ox.o.xooo.....x...ooxxo.o..x" + System.lineSeparator() +
				"x...x..oxxox.o..oxox.xoxo...oxo..oo....oxx.x...x.x" + System.lineSeparator() +
				".xoo.........xo.xxx...x.o.xoox...o.o.x..ox.xx.oxo." + System.lineSeparator() +
				"o.x...x.x.o.o...xo..oxxxo.xoo.xo.xo.ox.o...o...o.." + System.lineSeparator() +
				"xo.o.x..o.xx..o.....x..o.o....x.....ooo.oo.ooxx..o" + System.lineSeparator() +
				".xx.o.xoo.x.xxx.x.o.xxoo.ox.o.oo.x.xxo..ox.x.o.o.o" + System.lineSeparator() +
				".ox.o..xxo.ooxo.x.x.xx.xx.x...ooo.o..x....xo....ox" + System.lineSeparator() +
				"xx..ox.xx.x.x...ooxxox.oxx.o.oo.xo.o..x.x.xx..xxx." + System.lineSeparator() +
				"o....o..x..xoxxx....o....x....x.o.o.x....ooo...o.." + System.lineSeparator() +
				".xo.x...xox.............xo..xo....x..xoo.xx...x.ox" + System.lineSeparator() +
				".oxxxxx.xx..o.oxoxx...x...x..x.oxxoxxo..oxx..xx..." + System.lineSeparator() +
				".o..x.x.o...x..oo..o.x..xxox..o.oo.....x..x..o.oo." + System.lineSeparator() +
				"ox.xo.xx.x..xo.oxooo..o.xxo.xox.o.x..xoo..o.x..oo." + System.lineSeparator() +
				".xoox...xoox...ooxx......o.oox....x.x.ox..o.ox.o.x" + System.lineSeparator() +
				".o..x.xx..x....o..x.ox...oxooo....x..x.......o..x." + System.lineSeparator() +
				".o.xx..x..ox...o.o.xoo..oxx..oxo.oo..o.x.o.o....oo" + System.lineSeparator() +
				"x..xx.....x...o.xx.x..xo..x.oxx...xo.o...xx...xo.o" + System.lineSeparator() +
				"xx.oox.oxxo...ox...o.x..xo.oooxo..x..ox.ox...o...x" + System.lineSeparator() +
				".oo...o.....o...xooxoxox.x.x...oo..xo.x.oo.x.xxxo." + System.lineSeparator() +
				"oox..o.x.xo...oox.x..x..o.x.xxxo.x.x...o.o..o....." + System.lineSeparator() +
				"xo.xx.o.x.xx.xo..oox..o..xoo...xo.o..ooo......oxox" + System.lineSeparator() +
				".o..xx..xxo.....x...o.x..xxoxooxo..ooo.xx.....x..o" + System.lineSeparator() +
				"o..o.x..x.o.ox.oxx.o.xo.xox.o....o.o.x.ox...x.xox." + System.lineSeparator() +
				"...o..oxoooo.x.o..oo....xo.xxxxxox..o.o.o....oo.o." + System.lineSeparator() +
				".xxo..x.x.oxoo.x.o....xxoxoo...ooxx.ox...ooo..x.x." + System.lineSeparator() +
				".xo..xxx.o..ox.oo....oox...xxo...oxx.o.ooo.o...oox" + System.lineSeparator() +
				"....ox.x.oo.o.x..x....o...o...x.oxx.oxo..o...oooo." + System.lineSeparator() +
				"xxx..ox...x.x.x.o.x......xx..xx.ox.x......o.x..o.x" + System.lineSeparator() +
				"...oox.xox.ox.xx.x....x.oxxx..xxoxo.o.o....oxx...x" + System.lineSeparator() +
				"xoo.....ooxxxoxxxxx.....oxxx.....x..x...x..o.x..oo" + System.lineSeparator() +
				"..xo.oooxo...xx..x....x..oox.x.oxooo.oxoox...oxxo." + System.lineSeparator() +
				"...ox.o.xo.oxxx....o..xooxox..x.xo...oo.xooo.x.xox" + System.lineSeparator() +
				"xx..o.oo...ox.x.x.ooxxxox...o..ox...ox....xx..xo.." + System.lineSeparator() +
				"xx.ooo..o.xoox.x.oox.o.xxxoooox.o..oo..x.x.xx....o" + System.lineSeparator() +
				".oo...oxo.x.o.xx.o..xoxxox..x.xx.......xoxoxx.oxoo" + System.lineSeparator() +
				"...ox.ooooo.xxx.x..o.x.x.....xo..oo.xx..xo....ooox" + System.lineSeparator() +
				".o.xx..o..xoxxo.xoo..xooo.xx.ox.xxxo.o.xo..o...x.." + System.lineSeparator() +
				".xx...xoo.x.x.o.xo.o.xoxxo..oxo.ox....xoox.ox.xxxo" + System.lineSeparator() +
				"x.x..xox.....oxo..oo.ooxo...xo...ox.o..oo....ox.xo" + System.lineSeparator() +
				".xx....xx.o....x.xoo.x.x.oxxooxxo..x..x..xxxxxo.ox" + System.lineSeparator() +
				".o.x.x..x.oxoxx.xo..ox...ox.o......x.xxo...oo.oxx." + System.lineSeparator() +
				"xx.xoxo.oo....ooxoxxxxxxxxoxxxx...oxx.o..oo.xo..xo" + System.lineSeparator() +
				"xx....o.o.xo.oox...o..o.x..o..x..x..xoxooxo.ox.oox" + System.lineSeparator() +
				"o.x..o.x..o.oo..ooo.x.......x.xx.o...oo..ox.x.xxx." + System.lineSeparator() +
				".xxoxoxxoo.o.o......xx..xxo.x....oox.x.xo.x..x...." + System.lineSeparator() +
				"oxx.oox....oxxx....x.oox..o.xx..xoxx.x.oo.o.o.x..x" + System.lineSeparator() +
				"....x.x.ox.xooxo.x..x.xo....oxoo..o.x.oo..o..x..x." + System.lineSeparator() +
				"..o.o.xx....o...oooo...x.oox..oxox.x.x.x.xx...o.oo" + System.lineSeparator() +
				"..x.o.xo...xxx.x.ox.....oxo..ooxo..x.o.x..ooooxxox";
		String output = ".oo...x....xoo.xooooo.xx..xxo..xx.xoox.o..x..oo.o." + System.lineSeparator() +
				"o..ox.xoxxox.xo..ooxx.ox.o.xooo.....x...ooxxo.o..x" + System.lineSeparator() +
				"x...x..oxxox.o..oxox.xoxo...oxo..oo....oxx.x...x.x" + System.lineSeparator() +
				".xoo.........xo.xxx...x.o.xoox...o.o.x..ox.xx.oxo." + System.lineSeparator() +
				"o.x...x.x.o.o...xo..oxxxo.xoo.xo.xo.ox.o...o...o.." + System.lineSeparator() +
				"xo.o.x..o.xx..o.....x..o.o....x.....ooo.oo.ooxx..o" + System.lineSeparator() +
				".xx.o.xoo.x.xxx.x.o.xxoo.ox.o.oo.x.xxo..ox.x.o.o.o" + System.lineSeparator() +
				".ox.o..xxo.ooxo.x.x.xx.xx.x...ooo.o..x....xo....ox" + System.lineSeparator() +
				"xx..ox.xx.x.x...ooxxox.oxx.o.oo.xo.o..x.x.xx..xxx." + System.lineSeparator() +
				"o....o..x..xoxxx....o....x....x.o.o.x....ooo...o.." + System.lineSeparator() +
				".xo.x...xox.............xo..xo....x..xoo.xx...x.ox" + System.lineSeparator() +
				".oxxxxx.xx..o.oxoxx...x...x..x.oxxoxxo..oxx..xx..." + System.lineSeparator() +
				".o..x.x.o...x..oo..o.x..xxox..o.oo.....x..x..o.oo." + System.lineSeparator() +
				"ox.xo.xx.x..xo.oxooo..o.xxo.xox.o.x..xoo..o.x..oo." + System.lineSeparator() +
				".xoox...xoox...ooxx......o.oox....x.x.ox..o.ox.o.x" + System.lineSeparator() +
				".o..x.xx..x....o..x.ox...oxooo....x..x.......o..x." + System.lineSeparator() +
				".o.xx..x..ox...o.o.xoo..oxx..oxo.oo..o.x.o.o....oo" + System.lineSeparator() +
				"x..xx.....x...o.xx.x..xo..x.oxx...xo.o...xx...xo.o" + System.lineSeparator() +
				"xx.oox.oxxo...ox...o.x..xo.oooxo..x..ox.ox...o...x" + System.lineSeparator() +
				".oo...o.....o...xooxoxox.x.x...oo..xo.x.oo.x.xxxo." + System.lineSeparator() +
				"oox..o.x.xo...oox.x..x..o.x.xxxo.x.x...o.o..o....." + System.lineSeparator() +
				"xo.xx.o.x.xx.xo..oox..o..xoo...xo.o..ooo......oxox" + System.lineSeparator() +
				".o..xx..xxo.....x...o.x..xxoxooxo..ooo.xx.....x..o" + System.lineSeparator() +
				"o..o.x..x.o.ox.oxx.o.xo.xox.o....o.o.x.ox...x.xox." + System.lineSeparator() +
				"...o..oxoooo.x.o..oo....xo.xxxxxox..o.o.o....oo.o." + System.lineSeparator() +
				".xxo..x.x.oxoo.x.o....xxoxoo...ooxx.ox...ooo..x.x." + System.lineSeparator() +
				".xo..xxx.o..ox.oo....oox...xxo...oxx.o.ooo.o...oox" + System.lineSeparator() +
				"....ox.x.oo.o.x..x....o...o...x.oxx.oxo..o...oooo." + System.lineSeparator() +
				"xxx..ox...x.x.x.o.x......xx..xx.ox.x......o.x..o.x" + System.lineSeparator() +
				"...oox.xox.ox.xx.x....x.oxxx..xxoxo.o.o....oxx...x" + System.lineSeparator() +
				"xoo.....ooxxxoxxxxx.....oxxx.....x..x...x..o.x..oo" + System.lineSeparator() +
				"..xo.oooxo...xx..x....x..oox.x.oxooo.oxoox...oxxo." + System.lineSeparator() +
				"...ox.o.xo.oxxx....o..xooxox..x.xo...oo.xooo.x.xox" + System.lineSeparator() +
				"xx..o.oo...ox.x.x.ooxxxox...o..ox...ox....xx..xo.." + System.lineSeparator() +
				"xx.ooo..o.xoox.x.oox.o.xxxoooox.o..oo..x.x.xx....o" + System.lineSeparator() +
				".oo...oxo.x.o.xx.o..xoxxox..x.xx.......xoxoxx.oxoo" + System.lineSeparator() +
				"...ox.ooooo.xxx.x..o.x.x.....xo..oo.xx..xo....ooox" + System.lineSeparator() +
				".o.xx..o..xoxxo.xoo..xooo.xx.ox.xxxo.o.xo..o...x.." + System.lineSeparator() +
				".xx...xoo.x.x.o.xo.o.xoxxo..oxo.ox....xoox.ox.xxxo" + System.lineSeparator() +
				"x.x..xox.....oxo..oo.ooxo...xo...ox.o..oo....ox.xo" + System.lineSeparator() +
				".xx....xx.o....x.xoo.x.x.oxxooxxo..x..x..xxxxxo.ox" + System.lineSeparator() +
				".o.x.x..x.oxoxx.xo..ox...ox.o......x.xxo...oo.oxx." + System.lineSeparator() +
				"xx.xoxo.oo....ooxoxxxxxxxxoxxxx...oxx.o..oo.xo..xo" + System.lineSeparator() +
				"xx....o.o.xo.oox...o..o.x..o..x..x..xoxooxo.ox.oox" + System.lineSeparator() +
				"o.x..o.x..o.oo..ooo.x.......x.xx.o...oo..ox.x.xxx." + System.lineSeparator() +
				".xxoxoxxoo.o.o......xx..xxo.x....oox.x.xo.x..x...." + System.lineSeparator() +
				"oxx.oox....oxxx....x.oox..o.xx..xoxx.x.oo.o.o.x..x" + System.lineSeparator() +
				"....x.x.ox.xooxo.x..x.xo....oxoo..o.x.oo..o..x..x." + System.lineSeparator() +
				"..o.o.xx....o...oooo...x.oox..oxox.x.x.x.xx...o.oo" + System.lineSeparator() +
				"..x.o.xo...xxx.x.ox.....oxo..ooxo..x.o.x..ooooxxox";

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
