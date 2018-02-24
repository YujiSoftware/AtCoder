import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String path = "example_01.txt";
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		String input = new String(bytes, StandardCharsets.US_ASCII);
		String output = "";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String path = "example_02.txt";
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		String input = new String(bytes, StandardCharsets.US_ASCII);
		String output = "";

		assertIO(input, output);
	}

	@Test
	@Ignore
	public void create() throws Exception {
		int N = 100;
		Random random = new Random();

		Main.Board board = new Main.Board(N);
		for (int i = 0; i < 1000; i++) {
			int x = random.nextInt(N);
			int y = random.nextInt(N);
			board.setValue(x, y, 1 + random.nextInt(N - 1));
		}

		StringBuilder input = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				input.append(board.getValue(i, j)).append(' ');
			}
			input.append(System.lineSeparator());
		}

		String path = "C:\\Users\\Yuzi\\Desktop\\AtCoder\\example_02.txt";
		byte[] bytes = input.toString().getBytes();
		Files.write(Paths.get(path), bytes);

		return;
	}

	@Test
	public void testBoard() throws Exception {
		Main.Board board = new Main.Board(10);
		board.setValue(3, 3, 3);

		System.out.println(board.toString());
	}

	private void assertIO(String input, String output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// ByteArrayOutputStream out = new ByteArrayOutputStream();
		// System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		// Assert.assertThat(out.toString(), is(output +
		// System.lineSeparator()));
	}
}
