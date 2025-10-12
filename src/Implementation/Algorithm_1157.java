package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_1157 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String word;
    static int[] count;

    static void input() {
        word = scan.next();
        count = new int[97];
    }

    static void pro() {
        int a;
        for (int i = 0; i < word.length(); i++) {
            a = (int) word.charAt(i);
            if (a >= 97) {
                a -= 32;
            }
            count[a]++;
        }

        int maxValue = 0;
        char answer = '?';
        for (int i = 0; i < count.length; i++) {
            if (maxValue < count[i]) {
                answer = (char) i;
                maxValue = count[i];
            } else if (maxValue == count[i]) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args){
        input();
        pro();

        System.out.println(sb.toString());
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

