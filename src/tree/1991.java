import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] childs;

    static void input() {
        N = scan.nextInt();
        childs = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            char curCh = scan.next().charAt(0);
            int cur = (int)(curCh - 'A');
            for (int j = 0; j < 2; j++) {
                char ch = scan.next().charAt(0);
                if (ch != '.') {
                    childs[cur][j] = (int)(ch - 'A');
                } else {
                    childs[cur][j] = -1;
                }
            }
        }
    }

    static void preorder(int x) {
        if (x == -1) {
            return;
        }
        sb.append((char)(x + 'A'));
        preorder(childs[x][0]);
        preorder(childs[x][1]);
    }

    static void inorder(int x) {
        if (x == -1) {
            return;
        }
        inorder(childs[x][0]);
        sb.append((char)(x + 'A'));
        inorder(childs[x][1]);
    }

    static void postorder(int x) {
        if (x == -1) {
            return;
        }
        postorder(childs[x][0]);
        postorder(childs[x][1]);
        sb.append((char)(x + 'A'));
    }

    static void pro() {
        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);

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