package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm_1747 {
    static FastReader scan = new FastReader();

    static int N;
    static StringBuilder sb;

    static void input() {
        N = scan.nextInt();
        sb = new StringBuilder();
    }

    static boolean isPrime(int N) {
        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(N % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(int N) {
        String a = String.valueOf(N);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != a.charAt((a.length() - 1) - i)) {
                return false;
            }
        }
        return true;
    }

    static void rec_func(int N) {
        if (N == 1) {
            sb.append(2);
            return;
        }
        if (isPrime(N)) {
            if (isPalindrome(N)) {
                sb.append(N);
            } else {
                rec_func(N + 1);
            }
        } else {
            rec_func(N + 1);
        }
    }

    public static void main(String[] args){
        input();
        rec_func(N);

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
