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
                "1 1 8 2 2 4" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "4 5";
        String output =
                "NO";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "1 1 8 2 2 6" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "4 5";
        String output =
                "YES";

        assertIO(input, output);
    }

    @Test
    public void 入力例3() throws Exception {
        String input =
                "1 1 8 2 2 5" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "4 5";
        String output =
                "YES";

        assertIO(input, output);
    }

    @Test
    public void 入力例4() throws Exception {
        String input =
                "7 7 1 1 3 4" + System.lineSeparator() +
                        "3" + System.lineSeparator() +
                        "8 1" + System.lineSeparator() +
                        "1 7" + System.lineSeparator() +
                        "9 9";
        String output =
                "YES";

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
