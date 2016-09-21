import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    private static final int MOD = 1_000_000_007;
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        char[] S = sc.next().toCharArray();

        boolean[] changed = new boolean[N];
        int count = 0;
        for (int i = 0; i < S.length; i++) {
            int index = i;
            for (int j = i + 1; j < S.length; j++) {
                if (S[index] > S[j]) {
                    index = j;
                }
            }

            if (index != i) {
                char tmp = S[i];
                S[i] = S[index];
                S[index] = tmp;

                count += changed[i] ? 0: 1;
                count += changed[index] ? 0: 1;

                changed[i] = true;
                changed[index] = true;

                if (count == K) {
                    break;
                }
            }
        }

        System.out.println(S);
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
