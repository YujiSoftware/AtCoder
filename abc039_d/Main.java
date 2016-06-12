import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        char[][] S = new char[H][];
        for (int i = 0; i < H; i++) {
            S[i] = sc.next().toCharArray();
        }

        boolean[][] map = new boolean[H][];
        for (int i = 0; i < H; i++) {
            map[i] = new boolean[W];
        }

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                if (S[y][x] == '#') {
                    boolean success = true;

                    OuterLoop:
                    for (int yy = Math.max(0, y - 1); yy < Math.min(H, y + 2); yy++) {
                        for (int xx = Math.max(0, x - 1); xx < Math.min(W, x + 2); xx++) {
                            if (S[yy][xx] == '.') {
                                success = false;
                                break OuterLoop;
                            }
                        }
                    }

                    if (success) {
                        map[y][x] = true;
                    }
                }
            }
        }

        boolean[][] base = new boolean[H][];
        for (int i = 0; i < H; i++) {
            base[i] = new boolean[W];
        }

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                if (map[y][x]) {
                    for (int yy = Math.max(0, y - 1); yy < Math.min(H, y + 2); yy++) {
                        for (int xx = Math.max(0, x - 1); xx < Math.min(W, x + 2); xx++) {
                            base[yy][xx] = true;
                        }
                    }
                }
            }
        }

        boolean success = true;
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                if ((base[y][x] && S[y][x] == '.') || (!base[y][x] && S[y][x] == '#')) {
                    success = false;
                    break;
                }
            }
        }

        if (success) {
            System.out.println("possible");

            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    System.out.print(map[y][x] ? '#' : '.');
                }
                System.out.println();
            }
        } else {
            System.out.println("impossible");
        }

        if(false) {
            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    System.err.print(map[y][x] ? '#' : '.');
                }
                System.err.println();
            }
            System.err.println();
        }
    }

    public static class Pair {
        private int width;
        private int height;

        public Pair(int width, int height) {
            super();
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return "{" + width + ", " + height + "}";
        }
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
