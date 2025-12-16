import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] A, extension;

    static void input() {
        N = scan.nextInt();
        A = new String[N + 1];
        extension = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.next();
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            int idx = A[i].indexOf('.');
            String ext = A[i].substring(idx + 1);
            extension[i] = ext;
        }
        Arrays.sort(extension, 1, N + 1);
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (extension[i] == extension[i - 1]) {
                cnt++;
            } else {
                System.out.println(cnt);
                cnt = 0;
            }
        }
        if (cnt != 0) {
            System.out.println(cnt);
        }
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