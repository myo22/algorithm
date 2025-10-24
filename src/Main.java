import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();

    static int T, N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] A, B;

    static int lower_bound(int[] A, int L, int R, int x) {
        int result = L - 1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(A[mid] < x) {
                result = mid;
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }
        return result;
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(B);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += lower_bound(B, 1, M, A[i]);
        }
        sb.append(ans).append("\n");
    }

    public static void main(String[] args){
        T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }

        System.out.println(sb.toString());
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