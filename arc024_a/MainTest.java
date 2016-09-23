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
                "3 3" + System.lineSeparator() +
                        "20 21 22" + System.lineSeparator() +
                        "30 22 15";
        String output =
                "1";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "3 4" + System.lineSeparator() +
                        "10 11 10" + System.lineSeparator() +
                        "12 10 11 25";
        String output =
                "2";

        assertIO(input, output);
    }

    @Test
    public void 入力例3() throws Exception {
        String input =
                "5 5" + System.lineSeparator() +
                        "10 10 10 10 10" + System.lineSeparator() +
                        "10 10 10 10 10";
        String output =
                "5";

        assertIO(input, output);
    }

    @Test
    public void 入力例4() throws Exception {
        String input =
                "5 5" + System.lineSeparator() +
                        "10 11 12 13 14" + System.lineSeparator() +
                        "30 31 32 33 34";
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
