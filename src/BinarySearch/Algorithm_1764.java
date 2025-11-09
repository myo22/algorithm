package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm_1764 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] A, B;

    static void input() {
        N = scan.nextInt();
        A = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextLine();
        }
    }

    static boolean binary_search(String[] A, int left, int right, String X) {
        while(left <= right) {
            int mid = (left + right) / 2;
            if (A[mid].equals(X)) {
                return true;
            }
            if(A[mid].compareTo(X) < 0) {
                left = mid + 1;
            } else if (A[mid].compareTo(X) > 0) {
                right = mid - 1;
            }
        }
        return false;
    }

    static void pro() {
        int M = scan.nextInt(), ansCnt = 0;
        B = new String[M + 1];
        Arrays.sort(A, 1, N + 1);
        for (int i = 1; i <= M; i++) {
            String X = scan.nextLine();
            if(binary_search(A, 1, N, X)) {
                B[++ansCnt] = X;
            }
        }
        Arrays.sort(B, 1, ansCnt + 1);
        sb.append(ansCnt).append("\n");
        for (int i = 1; i <= ansCnt; i++) {
            sb.append(B[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}