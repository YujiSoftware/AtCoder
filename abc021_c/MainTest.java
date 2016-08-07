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
                "7" + System.lineSeparator() +
                        "1 7" + System.lineSeparator() +
                        "8" + System.lineSeparator() +
                        "1 2" + System.lineSeparator() +
                        "1 3" + System.lineSeparator() +
                        "4 2" + System.lineSeparator() +
                        "4 3" + System.lineSeparator() +
                        "4 5" + System.lineSeparator() +
                        "4 6" + System.lineSeparator() +
                        "7 5" + System.lineSeparator() +
                        "7 6";
        String output =
                "4";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "7" + System.lineSeparator() +
                        "1 7" + System.lineSeparator() +
                        "9" + System.lineSeparator() +
                        "1 2" + System.lineSeparator() +
                        "1 3" + System.lineSeparator() +
                        "4 2" + System.lineSeparator() +
                        "4 3" + System.lineSeparator() +
                        "4 5" + System.lineSeparator() +
                        "4 6" + System.lineSeparator() +
                        "7 5" + System.lineSeparator() +
                        "7 6" + System.lineSeparator() +
                        "4 7";
        String output =
                "2";

        assertIO(input, output);
    }

    @Test
    public void 入力例3() throws Exception {
        String input =
                "4" + System.lineSeparator() +
                        "1 2" + System.lineSeparator() +
                        "4" + System.lineSeparator() +
                        "1 2" + System.lineSeparator() +
                        "1 3" + System.lineSeparator() +
                        "4 2" + System.lineSeparator() +
                        "4 3" + System.lineSeparator();
        String output =
                "1";

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
