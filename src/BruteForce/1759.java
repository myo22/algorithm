import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int L, C;
    static char[] word, chars;

    static void input() {
        L = scan.nextInt();
        C = scan.nextInt();
        word = new char[C + 1];
        chars = new char[L + 1];
        String[] tokens = scan.nextLine().split(" ");
        for (int i = 1; i <= C; i++) {
            word[i] = tokens[i - 1].charAt(0);
        }
    }

    static void rec_func(int k, int start, int vowel, int consonant) {
        if (k == L + 1) {
            if (vowel >= 1 && consonant >= 2) {
                for (int i = 1; i <= L; i++) {
                    sb.append(chars[i]);
                }
                sb.append("\n");
            }
        } else {
            for (int i = start; i <= C; i++) {
                chars[k] = word[i];
                if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') {
                    rec_func(k + 1, i + 1, vowel + 1, consonant);
                } else {
                    rec_func(k + 1, i + 1, vowel, consonant + 1);
                }
            }
        }
    }

    static void pro() {
        Arrays.sort(word, 1, C + 1);
        rec_func(1, 1, 0 ,0);
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