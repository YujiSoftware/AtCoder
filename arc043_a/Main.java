import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int[] S = sc.nextInt(N);

        int min = IntStream.of(S).min().getAsInt();
        int max = IntStream.of(S).max().getAsInt();

        double P = B / (double) (max - min);
        double avg = IntStream.of(S).mapToDouble(s -> s * P).average().getAsDouble();
        double Q = A - avg;

        if(Double.isInfinite(P)){
            System.out.println(-1);
        }else{
            System.out.println(P + " " + Q);
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