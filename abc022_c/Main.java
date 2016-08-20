import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

    private static final int MOD = 1_000_000_007;
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] startToNextNode = new int[N];
        Arrays.fill(startToNextNode, INF);

        int[][] route = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(route[i], INF);
            route[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int l = sc.nextInt();

            if (u == 0) {
                startToNextNode[v] = l;
            } else {
                route[u][v] = l;
                route[v][u] = l;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                for (int k = 1; k < N; k++) {
                    route[j][k] = Math.min(route[j][k], route[j][i] + route[i][k]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (startToNextNode[i] != INF && startToNextNode[j] != INF && route[i][j] != INF) {
                    result = Math.min(result, startToNextNode[i] + startToNextNode[j] + route[i][j]);
                }
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
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
