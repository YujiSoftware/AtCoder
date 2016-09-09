import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final int MOD = 1_000_000_007;
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] s1 = sc.next().toCharArray();
        char[] s2 = sc.next().toCharArray();

        // 記号 => 数字のマッピング
        Map<Character, Character> map = new HashMap<>();

        boolean converted ;
        do {
            converted = false;

            for (int i = 0; i < N; i++) {
                if (s1[i] != s2[i]) {
                    if (Character.isDigit(s1[i]) && !Character.isDigit(s2[i])) {
                        map.put(s2[i], s1[i]);
                        s2[i] = s1[i];
                        converted = true;
                    } else if (!Character.isDigit(s1[i]) && Character.isDigit(s2[i])) {
                        map.put(s1[i], s2[i]);
                        s1[i] = s2[i];
                        converted = true;
                    }
                }

                Character c1 = map.get(s1[i]);
                if (c1 != null) {
                    s1[i] = c1;
                    converted = true;
                }
                Character c2 = map.get(s2[i]);
                if (c2 != null) {
                    s2[i] = c2;
                    converted = true;
                }
            }
        } while (converted);

        Set<Character> used = new HashSet<>();
        long pattern = 1;
        for(int i = 0; i < N; i++){
            if(!Character.isDigit(s1[i]) && !Character.isDigit(s2[i])){
                if(!used.contains(s1[i]) && !used.contains(s2[i]) ){
                    pattern *= (i == 0) ? 9 : 10;
                }

                used.add(s1[i]);
                used.add(s2[i]);
            }
        }

        // System.err.println(s1);
        // System.err.println(s2);

        System.out.println(pattern);
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
