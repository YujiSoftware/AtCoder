import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Route> route = new ArrayList<>();
        List<Route> init = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int l = sc.nextInt();

            if (u == 1) {
                init.add(new Route(i, u, v, l));
            } else if (v == 1) {
                init.add(new Route(i, v, u, l));
            } else {
                route.add(new Route(i, u, v, l));
                route.add(new Route(i, v, u, l));
            }
        }

        Map<Integer, List<Route>> map =
                route.stream().collect(Collectors.groupingBy(Route::getFrom));

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < init.size() - 1; i++) {
            Route start = init.get(i);

            PriorityQueue<Trace> queue = new PriorityQueue<>();
            queue.add(new Trace(start.to));

            int[] costs = new int[N];
            Arrays.fill(costs, -1);

            while (!queue.isEmpty()) {
                Trace trace = queue.poll();

                if (costs[trace.current - 1] >= 0) {
                    continue;
                }
                costs[trace.current - 1] = trace.length;

                List<Route> nextRoute = map.get(trace.current);
                if (nextRoute != null) {
                    for (Route next : nextRoute) {
                        queue.add(new Trace(trace, next));
                    }
                }
            }

            for (Route goal : init) {
                if (start.to == goal.to) {
                    continue;
                }

                int cost = costs[goal.to - 1];
                if (cost >= 0) {
                    min = Math.min(min, cost + start.length + goal.length);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static class Trace implements Comparable<Trace> {
        private int length;
        private int current;

        public Trace(int start) {
            this.length = 0;
            this.current = start;
        }

        public Trace(Trace trace, Route next) {
            this.length = trace.length + next.length;
            this.current = next.to;
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
