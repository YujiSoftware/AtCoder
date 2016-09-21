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
                "3 2" + System.lineSeparator() +
                        "abc";
        String output =
                "abc";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "7 2" + System.lineSeparator() +
                        "atcoder";
        String output =
                "actoder";

        assertIO(input, output);
    }

    @Test
    public void 入力例3() throws Exception {
        String input =
                "7 7" + System.lineSeparator() +
                        "atcoder";
        String output =
                "acdeort";

        assertIO(input, output);
    }

    @Test
    public void 入力例4() throws Exception {
        String input =
                "10 3" + System.lineSeparator() +
                        "helloworld";
        String output =
                "dehloworll";

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
