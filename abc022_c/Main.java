import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
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
            route[index] = new Route(i, u, v, l);
            route[index + 1] = new Route(i, v, u, l);
        }

        Map<Integer, List<Route>> map =
                Stream.of(route).collect(Collectors.groupingBy(Route::getFrom));

        PriorityQueue<Trace> queue = new PriorityQueue<>();
        queue.add(new Trace());

        while (!queue.isEmpty()) {
            Trace trace = queue.poll();
            if (trace.isGoal()) {
                // System.err.println(trace.routed.toString());
                System.out.println(trace.length);
                return;
            }

            for (Route next : map.get(trace.current)) {
                if (!trace.routed.contains(next.index) && !trace.towns.contains(next.to)) {
                    queue.add(new Trace(trace, next));
                }
            }
        }

        System.out.println(-1);
    }

    public static class Trace implements Comparable<Trace> {
        private Set<Integer> routed;
        private Set<Integer> towns;
        private int length;
        private int current;

        public Trace() {
            this.routed = new HashSet<>();
            this.towns = new HashSet<>();
            this.length = 0;
            this.current = 1;
        }

        public Trace(Trace trace, Route next) {
            this.routed = new HashSet<>(trace.routed);
            this.routed.add(next.index);

            this.towns = new HashSet<>(trace.towns);
            this.towns.add(next.to);

            this.length = trace.length + next.length;
            this.current = next.to;
        }

        public boolean isGoal() {
            return this.current == 1 && !routed.isEmpty();
        }

        @Override
        public int compareTo(Trace o) {
            return this.length - o.length;
        }
    }

    private static class Route {
        private int index;
        private int from;
        private int to;
        private int length;

        public Route(int index, int from, int to, int length) {
            this.index = index;
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
