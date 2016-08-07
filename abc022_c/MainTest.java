import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;

public class MainTest {

    @Test
    public void 入力例1() throws Exception {
        String input =
                "5 7" + System.lineSeparator() +
                        "1 2 2" + System.lineSeparator() +
                        "1 4 1" + System.lineSeparator() +
                        "2 3 7" + System.lineSeparator() +
                        "1 5 12" + System.lineSeparator() +
                        "3 5 2" + System.lineSeparator() +
                        "2 5 3" + System.lineSeparator() +
                        "3 4 5";
        String output =
                "13";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "5 4" + System.lineSeparator() +
                        "1 2 1" + System.lineSeparator() +
                        "1 3 1" + System.lineSeparator() +
                        "1 4 1" + System.lineSeparator() +
                        "1 5 1";
        String output =
                "-1";

        assertIO(input, output);
    }

    @Test
    public void 入力例3() throws Exception {
        String input =
                "10 12" + System.lineSeparator() +
                        "1 4 3" + System.lineSeparator() +
                        "1 9 1" + System.lineSeparator() +
                        "2 5 4" + System.lineSeparator() +
                        "2 6 1" + System.lineSeparator() +
                        "3 7 5" + System.lineSeparator() +
                        "3 10 9" + System.lineSeparator() +
                        "4 7 2" + System.lineSeparator() +
                        "5 6 6" + System.lineSeparator() +
                        "5 8 5" + System.lineSeparator() +
                        "6 8 3" + System.lineSeparator() +
                        "7 9 5" + System.lineSeparator() +
                        "8 10 8";
        String output =
                "11";

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
