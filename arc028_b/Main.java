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

        List<Coder> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            list.add(X[i]);
        }
        Collections.sort(list, new Comparator<Coder>() {
            @Override
            public int compare(Coder o1, Coder o2) {
                return o1.age - o2.age;
            }
        });

        StringBuilder builder = new StringBuilder();
        Coder current = list.get(K - 1);
        builder.append(current.index);
        builder.append(System.lineSeparator());

        for (int i = K; i < N; i++) {
            int limit = Math.min(K, list.size());
            for (int j = 0; j < limit; j++) {
                if (X[i].age < list.get(j).age) {
                    list.add(j, X[i]);
                    break;
                }
            }

            builder.append(list.get(K - 1).index);
            builder.append(System.lineSeparator());
        }

        System.out.print(builder.toString());
    }

    private static class Coder {
        private final int index;
        private final int age;

        public Coder(int index, int age) {
            this.index = index;
            this.age = age;
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
