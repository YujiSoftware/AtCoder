import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = sc.nextInt(N);

        Arrays.sort(T);

        int left = 0;
        int right = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (left < right) {
                left += T[i];
            } else {
                right += T[i];
            }
        }

        System.out.println(Math.max(left, right));
    }

    private static class Coder {
        public int index;
        public int rate;
        public int hand;

        public int win;
        public int loose;
        public int even;

        public Coder(int index, int rate, int hand) {
            this.index = index;
            this.rate = rate;
            this.hand = hand;
        }

        @Override
        public String toString() {
            return "Coder{" +
                    "index=" + (index + 1) +
                    ", hand=" + hand +
                    ", rate=" + rate +
                    '}';
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
