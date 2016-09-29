import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final int MOD = 1_000_000_007;
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Color[] color = new Color[N];
        for (int i = 0; i < N; i++) {
            color[i] = Color.valueOf(sc.nextInt());
        }

        Set<Colors> already = new HashSet<>();

        int day = 0;
        while (true) {
            day++;

            Color[] next = new Color[N];
            boolean updated = false;
            boolean prev = color[N - 1] == color[0];
            for (int i = 0; i < N; i++) {
                boolean current = color[i] == color[(i + 1) % N];
                if (prev && current) {
                    next[i] = color[i].reverse();
                    updated = true;
                } else {
                    next[i] = color[i];
                }

                prev = current;
            }

            if (!updated) {
                break;
            }

            if (!already.add(new Colors(next)) || day > 10000) {
                day = -1;
                break;
            }

            color = next;
        }

        System.out.println(day);
    }

    private static class Colors {
        private final Color[] colors;
        private final int hashCode;

        public Colors(Color[] colors) {
            this.colors = colors;
            this.hashCode = Arrays.hashCode(colors);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Colors other = (Colors) o;

            return Arrays.equals(this.colors, other.colors);
        }

        @Override
        public int hashCode() {
            return hashCode;
        }
    }

    public enum Color {
        BLACK,
        RED;

        public static Color valueOf(int value) {
            return value == 0 ? Color.BLACK : Color.RED;
        }

        public Color reverse() {
            return this == Color.BLACK ? Color.RED : Color.BLACK;
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
