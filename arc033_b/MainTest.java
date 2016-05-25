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
                        "1 3 5" + System.lineSeparator() +
                        "1 2";
        String output =
                "0.2500000000";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "9 10" + System.lineSeparator() +
                        "11 2 33 4 55 6 77 8 99" + System.lineSeparator() +
                        "10 11 14 19 55 1000000000 4 5 7 8";
        String output =
                "0.2666666667";

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
