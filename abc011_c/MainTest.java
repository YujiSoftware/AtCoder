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
                "2" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "7" + System.lineSeparator() +
                        "15";
        String output =
                "YES";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "5" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "4" + System.lineSeparator() +
                        "2";
        String output =
                "YES";

        assertIO(input, output);
    }

    @Test
    public void 入力例3() throws Exception {
        String input =
                "300" + System.lineSeparator() +
                        "57" + System.lineSeparator() +
                        "121" + System.lineSeparator() +
                        "244";
        String output =
                "NO";

        assertIO(input, output);
    }

    @Test
    public void 入力例4() throws Exception {
        String input =
                "6" + System.lineSeparator() +
                        "5" + System.lineSeparator() +
                        "4" + System.lineSeparator() +
                        "3";
        String output =
                "NO";

        assertIO(input, output);
    }

    @Test
    public void 入力例_マイナス3() throws Exception {
        String input =
                "6" + System.lineSeparator() +
                        "5" + System.lineSeparator() +
                        "4" + System.lineSeparator() +
                        "1";
        String output =
                "YES";

        assertIO(input, output);
    }

    @Test
    public void 入力例_マイナス2() throws Exception {
        String input =
                "6" + System.lineSeparator() +
                        "5" + System.lineSeparator() +
                        "3" + System.lineSeparator() +
                        "1";
        String output =
                "YES";

        assertIO(input, output);
    }

    @Test
    public void 入力例_マイナス1() throws Exception {
        String input =
                "6" + System.lineSeparator() +
                        "4" + System.lineSeparator() +
                        "3" + System.lineSeparator() +
                        "1";
        String output =
                "YES";

        assertIO(input, output);
    }

    @Test
    public void 入力例_100回ジャスト() throws Exception {
        String input =
                "300" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "2" + System.lineSeparator() +
                        "4";
        String output =
                "YES";

        assertIO(input, output);
    }

    @Test
    public void 入力例_NG数字がNと同じ場合も失敗となります() throws Exception {
        String input =
                "1" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "2" + System.lineSeparator() +
                        "3";
        String output =
                "NO";

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
