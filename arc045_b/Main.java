import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] sa = new int[m];
        int[] ta = new int[m];
        for (int i = 0; i < m; i++) {
            sa[i] = scanner.nextInt();
            ta[i] = scanner.nextInt();
        }

        int[] rooms = new int[n];
        for (int i = 0; i < m; i++) {
            int s = sa[i];
            int t = ta[i];
            for (int j = s; j <= t; j++) {
                rooms[j - 1]++;
            }
        }

        List<String> result = new ArrayList<>();
        OuterLoop:
        for (int i = 0; i < m; i++) {
            int s = sa[i];
            int t = ta[i];
            for (int j = s; j <= t; j++) {
                if (rooms[j - 1] == 1) {
                    continue OuterLoop;
                }
            }

            result.add(Integer.toString(i + 1));
        }

        System.out.println(result.size());
        if (!result.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), result));
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
