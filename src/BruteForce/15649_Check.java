import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int [] arr;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M + 1];
        visit = new boolean[N + 1];
    }

    static void rec_func (int k) {
        if (M + 1 == k) {
            for (int i = 1; i <= M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (visit[i]) {
                    continue;
                }
                visit[i] = true;
                arr[k] = i;
                rec_func(k + 1);
                visit[i] = false;
                arr[k] = 0;
            }
        }
    }

    static void pro() {
        rec_func(1);
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