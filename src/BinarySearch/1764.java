import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static String[] A;
    static List<String> answer;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextLine();
        }
        Arrays.sort(A, 1, N + 1);
    }

    static void pro() {
        answer = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            binary_search(scan.nextLine());
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (String a : answer) {
            System.out.println(a);
        }
    }

    static void binary_search(String word) {
        int L = 1, R = N;
        while(L <= R) {
            int mid = (L + R) / 2;
            int cmp = A[mid].compareTo(word);
            if (cmp == 0) {
                answer.add(A[mid]);
                return;
            } else if (cmp < 0) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
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