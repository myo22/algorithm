package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_2512 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
    }

    static boolean determination(int h) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if(A[i] <= h) {
                sum += A[i];
            }else{
                sum += h;
            }
        }
        return sum <= M;
    }

    static void pro() {
        long total = 0;
        int max = 0;
        for (int i = 0; i <= N; i++) {
            total += A[i];
            if(max < A[i]) {
                max = A[i];
            }
        }

        if (total <= M) {
            System.out.println(max);
            return;
        }

        int L = 1, R = M, answer = 0;

        while(L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                answer = mid;
                L = mid + 1;
            } else{
                R = mid - 1;
            }
        }

        System.out.println(answer);
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
