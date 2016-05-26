import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int NA = sc.nextInt();
        int NB = sc.nextInt();
        int[] A = sc.nextInt(NA);
        int[] B = sc.nextInt(NB);

        Arrays.sort(A);
        Arrays.sort(B);

        int intersection = 0;
        int union = 0;
        int aPos = 0;
        int bPos = 0;
        while(aPos < A.length && bPos < B.length){
            if(A[aPos] < B[bPos]){
                union++;
                aPos++;
            }else if(A[aPos] > B[bPos]){
                union++;
                bPos++;
            }else{
                intersection++;
                union++;
                aPos++;
                bPos++;
            }
        }

        union += A.length - aPos;
        union += B.length - bPos;

        double jaccard = (double) intersection / union;

        System.out.println(jaccard);
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
