import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例_1() throws Exception {
		String input = "2 3 2" + System.lineSeparator() +
			"1 4 2" + System.lineSeparator() +
			"3 1 2";
		String output = "2 2" + System.lineSeparator() +
			"1 2" + System.lineSeparator() +
			"1 3" + System.lineSeparator() +
			"2 2" + System.lineSeparator() +
			"1 2" + System.lineSeparator() +
			"1 3" + System.lineSeparator() +
			"3 3" + System.lineSeparator() +
			"3 2" + System.lineSeparator() +
			"3 1" + System.lineSeparator() +
			"3 1" + System.lineSeparator() +
			"3 1" + System.lineSeparator() +
			"1 1" + System.lineSeparator() +
			"2 1" + System.lineSeparator() +
			"1 1" + System.lineSeparator() +
			"2 2" + System.lineSeparator() +
			"1 2" + System.lineSeparator() +
			"2 2" + System.lineSeparator() +
			"2 3" + System.lineSeparator() +
			"3 3" + System.lineSeparator() +
			"2 3";

		assertIO(input, output);
	}

	@Test
	public void 入力例_2() throws Exception {
		String input = "40 34 90 20 99 69 62 73 53 17 16 34 55 97 92 45 62 97 45 40 80 28 2 100 14 73 89 6 11 77"
			+ System.lineSeparator() +
			"4 1 45 76 33 40 46 39 90 83 4 34 27 41 52 16 74 75 51 34 74 64 77 28 60 92 29 16 30 62"
			+ System.lineSeparator() +
			"54 3 16 55 95 84 23 68 38 58 50 95 24 68 69 44 8 33 89 93 84 33 80 93 37 65 83 17 22 82"
			+ System.lineSeparator() +
			"12 64 39 58 10 40 51 18 50 21 95 47 9 46 49 69 29 4 44 45 91 75 32 33 99 63 41 62 5 79"
			+ System.lineSeparator() +
			"14 68 50 58 67 48 83 67 86 16 6 54 74 69 69 81 27 97 4 81 32 78 48 78 34 67 74 92 34 82"
			+ System.lineSeparator() +
			"18 20 47 84 76 10 81 2 2 1 100 91 51 66 21 92 58 68 36 5 69 17 23 87 66 17 57 6 84 93"
			+ System.lineSeparator() +
			"65 98 72 55 24 31 79 29 72 23 34 76 80 90 60 66 9 19 38 82 41 96 75 88 16 68 46 7 62 98"
			+ System.lineSeparator() +
			"81 96 43 45 93 82 17 37 99 16 71 73 43 32 77 78 95 20 70 47 73 45 48 69 90 53 66 83 50 97"
			+ System.lineSeparator() +
			"1 55 45 76 21 60 17 22 41 40 67 46 80 48 62 18 85 40 23 65 35 4 96 71 21 5 15 91 65 60"
			+ System.lineSeparator() +
			"100 7 55 1 31 26 68 17 63 99 84 74 81 61 99 82 87 87 32 15 66 77 66 41 38 73 13 48 56 36"
			+ System.lineSeparator() +
			"72 23 7 90 17 19 62 79 42 91 52 81 58 19 83 41 68 32 76 3 7 3 7 42 70 92 23 84 39 84"
			+ System.lineSeparator() +
			"6 9 48 91 17 49 97 41 74 38 42 41 67 32 88 80 79 19 28 64 52 99 20 39 94 99 54 64 72 73"
			+ System.lineSeparator() +
			"54 82 89 46 55 1 19 21 78 89 64 20 91 94 53 44 44 38 36 70 26 11 45 97 66 43 70 41 42 50"
			+ System.lineSeparator() +
			"29 78 40 95 94 98 76 9 32 43 97 8 65 9 6 87 88 89 89 39 52 34 64 37 49 75 16 30 82 34"
			+ System.lineSeparator() +
			"36 13 60 47 5 58 21 34 40 44 5 87 62 3 81 68 48 1 79 83 70 11 54 72 65 30 22 55 23 51"
			+ System.lineSeparator() +
			"16 4 22 81 71 53 93 98 57 45 77 41 94 64 1 30 49 81 25 43 11 50 4 88 42 76 77 19 62 82"
			+ System.lineSeparator() +
			"58 54 1 60 50 93 54 77 59 37 31 20 18 53 1 67 71 29 27 17 39 25 55 92 21 39 37 99 39 65"
			+ System.lineSeparator() +
			"98 53 64 97 30 22 100 100 59 31 66 6 74 3 76 49 47 26 76 1 43 21 39 25 83 74 61 100 98 27"
			+ System.lineSeparator() +
			"65 10 54 77 78 40 68 7 59 25 87 95 28 80 37 79 88 14 36 32 5 72 87 34 74 58 46 15 94 84"
			+ System.lineSeparator() +
			"54 16 68 63 89 18 71 34 57 78 46 27 27 90 78 6 18 97 82 78 19 53 45 46 66 41 83 30 6 93"
			+ System.lineSeparator() +
			"14 66 9 34 42 73 2 13 16 67 87 41 89 42 34 46 59 89 14 39 11 45 45 76 27 79 98 82 1 60"
			+ System.lineSeparator() +
			"25 34 78 70 29 5 68 9 5 100 65 85 2 30 41 22 61 87 3 81 54 29 51 62 3 48 68 70 24 21"
			+ System.lineSeparator() +
			"82 18 100 54 82 59 79 7 40 18 34 43 13 34 32 36 96 86 44 26 72 10 79 18 63 37 85 22 15 15"
			+ System.lineSeparator() +
			"68 39 85 61 10 7 12 27 50 59 77 1 62 14 73 16 74 56 69 24 72 4 92 32 76 87 19 85 94 12"
			+ System.lineSeparator() +
			"44 13 80 69 82 96 7 19 90 51 70 39 92 3 5 99 96 70 58 22 57 9 93 92 23 71 86 58 52 40"
			+ System.lineSeparator() +
			"66 99 60 62 85 14 20 25 25 41 66 33 44 4 69 97 39 47 61 50 49 34 40 70 78 15 75 36 25 76"
			+ System.lineSeparator() +
			"49 22 86 18 64 88 71 26 99 61 74 6 44 68 88 44 61 35 55 57 6 49 11 98 68 58 25 40 100 24"
			+ System.lineSeparator() +
			"99 95 65 64 78 90 34 19 27 54 52 58 29 71 75 34 66 17 38 50 10 69 69 68 7 92 31 8 81 13"
			+ System.lineSeparator() +
			"29 71 58 100 11 81 25 6 41 10 6 26 55 69 99 71 48 63 87 76 53 7 97 67 54 42 19 9 37 83"
			+ System.lineSeparator() +
			"46 54 33 57 33 76 79 29 55 76 49 2 74 82 8 82 34 31 86 98 10 23 65 70 49 18 93 76 40 14";

		String output = "";

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
