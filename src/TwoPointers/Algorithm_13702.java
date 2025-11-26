package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_13702 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K, max;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
            max = Math.max(max, A[i]);
        }
    }

    static long binary_search(long L, long R) {
        long ans = 0;
        while (L <= R) {
            // 여기도 한번 계산된 후 증가된 L + R을 생각못해서 int로하면 안됨
            long mid = (L + R) / 2;
            // mid가 0일때 처리를 안해줘서 A[i] / 0일때 Exception 주의
            if(mid != 0 && determination(mid)){
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    static boolean determination(long k) {
        int Cnt = 0;
        for (int i = 1; i <= N; i++) {
            Cnt += A[i] / k;
        }
        return Cnt >= K;
    }

    public static void main(String[] args){
        input();
        System.out.println(binary_search(1, max));
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