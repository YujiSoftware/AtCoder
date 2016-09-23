import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

    private static final int MOD = 1_000_000_007;
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R= sc.nextInt();
        List<Integer> leftList = new ArrayList<>();
        for(int i = 0; i < L; i++){
            leftList.add(sc.nextInt());
        }
        List<Integer> rightList = new ArrayList<>();
        for(int i = 0; i < R; i++){
            rightList.add(sc.nextInt());
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        Deque<Integer> leftQueue = new ArrayDeque<>(leftList);
        Deque<Integer> rightQueue = new ArrayDeque<>(rightList);

        int pair = 0;
        while(!leftQueue.isEmpty() && !rightQueue.isEmpty()){
            int left = leftQueue.peek();
            int right = rightQueue.peek();
            if(left < right) {
                leftQueue.pop();
            }else if(left > right) {
                rightQueue.pop();
            }else{
                pair++;
                leftQueue.pop();
                rightQueue.pop();
            }
        }

        System.out.println(pair);
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
