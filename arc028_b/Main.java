import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

    private static final int MOD = 1_000_000_007;
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Coder[] X = new Coder[N];
        for (int i = 0; i < N; i++) {
            X[i] = new Coder(i + 1, sc.nextInt());
        }

        TreeSet<Coder> set = new TreeSet<>();
        for (int i = 0; i < K; i++) {
            set.add(X[i]);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(set.last().index);
        builder.append(System.lineSeparator());

        for(int i = K; i<N;i++){
            set.add(X[i]);
            set.pollLast();

            builder.append(set.last().index);
            builder.append(System.lineSeparator());
        }

        System.out.print(builder.toString());
    }

    private static class Coder implements Comparable<Coder> {
        private final int index;
        private final int age;

        public Coder(int index, int age) {
            this.index = index;
            this.age = age;
        }

        @Override
        public int compareTo(Coder o) {
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return "Coder{" +
                    "index=" + index +
                    ", age=" + age +
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
