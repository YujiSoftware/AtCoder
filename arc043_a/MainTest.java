import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void 入力例1() throws Exception {
        String input =
                "5 2 4" + System.lineSeparator() +
                        "2" + System.lineSeparator() +
                        "4" + System.lineSeparator() +
                        "6" + System.lineSeparator() +
                        "8" + System.lineSeparator() +
                        "10";
        String output =
                "0.5 -1";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "13 29 31" + System.lineSeparator() +
                        "3" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "4" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "5" + System.lineSeparator() +
                        "9" + System.lineSeparator() +
                        "2" + System.lineSeparator() +
                        "6" + System.lineSeparator() +
                        "5" + System.lineSeparator() +
                        "3" + System.lineSeparator() +
                        "5" + System.lineSeparator() +
                        "8" + System.lineSeparator() +
                        "9";
        String output =
                "3.875 10.8173076";

        assertIO(input, output);
    }

    @Test
    public void 入力例3() throws Exception {
        String input =
                "5 1 2" + System.lineSeparator() +
                        "34" + System.lineSeparator() +
                        "34" + System.lineSeparator() +
                        "34" + System.lineSeparator() +
                        "34" + System.lineSeparator() +
                        "34";
        String output =
                "-1";

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
