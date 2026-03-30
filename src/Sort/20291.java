import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, count = 1;
    static String[] arr;

    static void input() {
        N = scan.nextInt();
        arr = new String[N + 1];
        for (int i = 1 ; i <= N; i++) {
            arr[i] = scan.nextLine().split("\\.")[1];
        }
    }

    static void pro() {
        Arrays.sort(arr, 1, N + 1);
        for (int i = 2 ; i <= N; i++) {
            if (arr[i - 1].equals(arr[i])) {
                count++;
            } else {
                sb.append(arr[i - 1]).append(" ").append(count).append("\n");
                count = 1;
            }
        }

        sb.append(arr[N]).append(" ").append(count);
        System.out.print(sb.toString());
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