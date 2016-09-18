import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    private static final int MOD = 1_000_000_007;
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long sum = (N == 1) ? 0 : 1;
        long limit = (long) Math.floor(Math.sqrt(N));
        // List<Long> list = new ArrayList<>();
        for (long i = 2; i <= limit; i++) {
            if (N % i == 0) {
                sum += i;
                // list.add(i);

                if (i != N / i) {
                    sum += N / i;
                    // list.add(N / i);
                }
            }
        }

        // System.err.println(Arrays.toString(list.toArray()));

        if (sum > N) {
            System.out.println("Abundant");
        } else if (sum < N) {
            System.out.println("Deficient");
        } else {
            System.out.println("Perfect");
        }
    }

    public static class Scanner {
        private BufferedInputStream inputStream;

        public Scanner(InputStream in) {
            inputStream = new BufferedInputStream(in);
        }

        public int nextInt() throws IOException {
            int num = 0;

            int read = skip();
            do {
                num = num * 10 + (read - 0x30);
            } while ((read = inputStream.read()) > 0x20);

            return num;
        }

        public int[] nextInt(int n) throws IOException {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }

            return array;
        }

        public long nextLong() throws IOException {
            long num = 0;

            int read = skip();
            do {
                num = num * 10 + (read - 0x30);
            } while ((read = inputStream.read()) > 0x20);

            return num;
        }

        public long[] nextLong(int n) throws IOException {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }

            return array;
        }

        public String next() throws IOException {
            StringBuilder builder = new StringBuilder();

            int read = skip();
            do {
                builder.append((char) read);
            } while ((read = inputStream.read()) > 0x20);

            return builder.toString();
        }

        private int skip() throws IOException {
            int read;
            while ((read = inputStream.read()) <= 0x20)
                ;

            return read;
        }
    }
}
