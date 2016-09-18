import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class MainTest {

    @Test
    public void 入力例1() throws Exception {
        String input =
                "6";
        String output =
                "Perfect";

        assertIO(input, output);
    }

    @Test
    public void 入力例2() throws Exception {
        String input =
                "24";
        String output =
                "Abundant";

        assertIO(input, output);
    }

    @Test
    public void 入力例3() throws Exception {
        String input =
                "27";
        String output =
                "Deficient";

        assertIO(input, output);
    }

    @Test
    public void 入力例4() throws Exception {
        String input =
                "945";
        String output =
                "Abundant";

        assertIO(input, output);
    }

    @Test
    public void 入力例5() throws Exception {
        String input =
                "196";
        String output =
                "Abundant";

        assertIO(input, output);
    }

    @Test
    public void 入力例() throws Exception {
        for (long N = 1; N < 10000; N++) {
            String input =
                    Long.toString(N);

            long sum = 0;
            List<Long> list = new ArrayList<>();
            for(long i = N / 2; i > 0; i--){
                if(N % i == 0){
                    sum += i;
                    list.add(i);
                }

                if(sum > N) {
                    break;
                }
            }

            String output;
            if(sum > N){
                output = "Abundant";
            }else if(sum < N){
                output = "Deficient";
            }else{
                output = "Perfect";
            }

            System.err.println(N);
            System.err.println(Arrays.toString(list.toArray()));
            assertIO(input, output);
        }
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
