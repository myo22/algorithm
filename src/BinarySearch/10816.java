import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] card;

    static void input() {
        N = scan.nextInt();
        card = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            card[i] = scan.nextInt();
        }
        M = scan.nextInt();
    }

    static int lower_bound(int L, int R, int k) {
        int ans = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (card[mid] >= k) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static int upper_bound(int L, int R, int k) {
        int ans = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (card[mid] > k) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }
    static void pro() {
        Arrays.sort(card, 1, N + 1);
        for (int i = 1; i <= M; i++) {
            int k = scan.nextInt();
            int upper = upper_bound(1, N, k);
            int lower = lower_bound(1, N, k);
            sb.append(upper - lower).append(' ');
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) throws IOException {
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