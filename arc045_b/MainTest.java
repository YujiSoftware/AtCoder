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
                "10 5" + System.lineSeparator() +
                        "1 4" + System.lineSeparator() +
                        "5 5" + System.lineSeparator() +
                        "6 8" + System.lineSeparator() +
                        "9 10" + System.lineSeparator() +
                        "5 6";
        String output =
                "2" + System.lineSeparator() +
                        "2" + System.lineSeparator() +
                        "5";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "3 6" + System.lineSeparator() +
                        "1 1" + System.lineSeparator() +
                        "1 1" + System.lineSeparator() +
                        "2 2" + System.lineSeparator() +
                        "2 2" + System.lineSeparator() +
                        "3 3" + System.lineSeparator() +
                        "3 3";
        String output =
                "6" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "2" + System.lineSeparator() +
                        "3" + System.lineSeparator() +
                        "4" + System.lineSeparator() +
                        "5" + System.lineSeparator() +
                        "6";

        assertIO(input, output);
    }

    @Test
    public void 入力例3() throws Exception {
        String input =
                "10 3" + System.lineSeparator() +
                        "1 4" + System.lineSeparator() +
                        "2 6" + System.lineSeparator() +
                        "6 10";
        String output =
                "0";

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
