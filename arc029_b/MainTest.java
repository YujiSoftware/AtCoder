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
                "1 6" + System.lineSeparator() +
                        "3" + System.lineSeparator() +
                        "8 3" + System.lineSeparator() +
                        "4 4" + System.lineSeparator() +
                        "5 5";
        String output =
                "YES" + System.lineSeparator() +
                        "NO" + System.lineSeparator() +
                        "YES";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "2 8" + System.lineSeparator() +
                        "2" + System.lineSeparator() +
                        "2 8" + System.lineSeparator() +
                        "8 2";
        String output =
                "YES" + System.lineSeparator() +
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
