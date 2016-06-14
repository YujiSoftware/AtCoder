import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<Integer> NG = new HashSet<>();
        NG.add(sc.nextInt());
        NG.add(sc.nextInt());
        NG.add(sc.nextInt());

        boolean success = false;
        for (int i = 0; i < 100; i++) {
            if (NG.contains(N)) {
                break;
            }

            if (!NG.contains(N - 3) && N - 3 >= 0) {
                N -= 3;
            } else if (!NG.contains(N - 2) && N - 2 >= 0) {
                N -= 2;
            } else if (!NG.contains(N - 1) && N - 1 >= 0) {
                N -= 1;
            } else {
                break;
            }

            if (N == 0) {
                success = true;
                break;
            }
        }

        System.out.println(success ? "YES" : "NO");
    }

    public static class Scanner {
        private BufferedInputStream inputStream;

        public Scanner(InputStream in) {
            inputStream = new BufferedInputStream(in);
        }

        public int nextInt() throws IOException {
            int num = 0;

            int read;
            while ((read = inputStream.read()) <= 0x20)
                ;

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

            int read;
            while ((read = inputStream.read()) <= 0x20)
                ;

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

            int read;
            while ((read = inputStream.read()) <= 0x20)
                ;

            do {
                builder.append((char) read);
            } while ((read = inputStream.read()) > 0x20);

            return builder.toString();
        }
    }
}