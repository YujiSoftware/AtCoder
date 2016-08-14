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
        int M = sc.nextInt();
        Route[] route = new Route[M * 2];
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int l = sc.nextInt();

            int index = i * 2;
            route[index] = new Route(i, index, u, v, l);
            route[index + 1] = new Route(i, index + 1, v, u, l);
        }

        Map<Integer, List<Route>> map =
                Stream.of(route).collect(Collectors.groupingBy(Route::getFrom));

        PriorityQueue<Trace> queue = new PriorityQueue<>();
        queue.add(new Trace(M));

        boolean[] checked = new boolean[M * 2];

        while (!queue.isEmpty()) {
            Trace trace = queue.poll();
            if (trace.isGoal()) {
                // System.err.println(trace.routed.toString());
                System.out.println(trace.length);
                return;
            }

            if (trace.prev != null) {
                if (checked[trace.prev.unique]) {
                    continue;
                }
                checked[trace.prev.unique] = true;
            }

            for (Route next : map.get(trace.current)) {
                if (!trace.routed[next.index]) {
                    queue.add(new Trace(trace, next));
                }
            }
        }

        System.out.println(-1);
    }

    public static class Trace implements Comparable<Trace> {
        private boolean[] routed;
        private int length;
        private int current;
        private Route prev;

        public Trace(int M) {
            this.routed = new boolean[M];
            this.length = 0;
            this.current = 1;
            this.prev = null;
        }

        public Trace(Trace trace, Route next) {
            this.routed = Arrays.copyOf(trace.routed, trace.routed.length);
            this.routed[next.index] = true;

            this.length = trace.length + next.length;
            this.current = next.to;
            this.prev = next;
        }

        public boolean isGoal() {
            return this.current == 1 && this.length > 0;
        }

        @Override
        public int compareTo(Trace o) {
            return this.length - o.length;
        }
    }

    private static class Route {
        private int index;
        private int unique;
        private int from;
        private int to;
        private int length;

        public Route(int index, int unique, int from, int to, int length) {
            this.index = index;
            this.unique = unique;
            this.from = from;
            this.to = to;
            this.length = length;
        }

        public int getIndex() {
            return index;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getLength() {
            return length;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "index=" + index +
                    ", from=" + from +
                    ", to=" + to +
                    ", length=" + length +
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
