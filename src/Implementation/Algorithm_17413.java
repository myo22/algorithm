package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_17413 {
    static FastReader scan = new FastReader();

    static String S;
    static StringBuilder word;
    static StringBuilder result;


    static void input() {
        S = scan.nextLine();
    }

    static void reverseAndAppend() {
        word.reverse();
        result.append(word);
        word = new StringBuilder();
    }

    static void pro() {
        word = new StringBuilder();
        result = new StringBuilder();
        boolean isTag = false;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '<') {
                if (!isTag) {
                    reverseAndAppend();
                }
                isTag = true;
                result.append(c);
            } else if (c == '>') {
                isTag = false;
                result.append(c);
            } else if (isTag) {
                result.append(c);
            } else {
                if (c == ' ') {
                    reverseAndAppend();
                    result.append(c);
                } else {
                    word.append(c);
                }
            }
        }
        if (word.length() > 0) {
            reverseAndAppend();
        }
    }

    public static void main(String[] args){
        input();
        pro();

        System.out.println(result.toString());
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