import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int M = sc.nextInt();
        Route[] route = new Route[M * 2];
        for (int i = 0; i < M * 2; i += 2) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            route[i] = new Route(x, y);
            route[i + 1] = new Route(y, x);
        }

        Map<Integer, List<Route>> map =
                Stream.of(route).collect(Collectors.groupingBy(Route::getFrom));

        PriorityQueue<Trace> queue = new PriorityQueue<>();
        queue.add(new Trace(new int[0], a));

        int[] shortest = new int[N + 1];
        int[] patterns = new int[N + 1];

        Arrays.fill(shortest, -1);

        int[] paths = null;
        while (!queue.isEmpty()) {
            Trace trace = queue.poll();
            int current = trace.getCurrent();

            if (shortest[current] != -1) {
                if (shortest[current] == trace.getLength()) {
                    patterns[current]++;
                }
                continue;
            }
            shortest[current] = trace.getLength();
            patterns[current]++;

            if (current == b) {
                paths = trace.paths;
                continue;
            }

            map.get(current)
                    .forEach(next -> queue.add(new Trace(trace.paths, next.getTo())));
        }

        // System.err.print(Arrays.toString(paths));
        // System.err.print(Arrays.toString(shortest));
        // System.err.print(Arrays.toString(patterns));

        int sum = 1;
        for (int path : paths) {
            int count = patterns[path];

            sum = (sum % MOD) * (count % MOD);
        }

        System.out.println(sum);
    }

    private static class Trace implements Comparable<Trace> {
        private final int[] paths;

        public Trace(int[] paths, int next) {
            this.paths = Arrays.copyOf(paths, paths.length + 1);
            this.paths[paths.length] = next;
        }

        public int getCurrent() {
            return this.paths[this.paths.length - 1];
        }

        public int getLength() {
            return this.paths.length;
        }

        @Override
        public int compareTo(Trace o) {
            return this.paths.length - o.paths.length;
        }
    }

    private static class Route {
        private final int from;
        private final int to;

        public Route(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Route route = (Route) o;

            if (from != route.from) return false;
            return to == route.to;

        }

        @Override
        public int hashCode() {
            int result = from;
            result = 31 * result + to;
            return result;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "from=" + from +
                    ", to=" + to +
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
