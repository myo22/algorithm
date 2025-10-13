package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Algorithm_1620 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] issue;
    static Map<String, Integer> collections;
    static Map<Integer, String> collections2;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        collections = new LinkedHashMap<>();
        collections2 = new LinkedHashMap<>();
        issue = new String[M];
        for (int i = 1; i <= N; i++) {
            String word = scan.next();
            collections.put(word, i);
            collections2.put(i, word);
        }
        for (int i = 0; i < M; i++) {
            issue[i] = scan.next();
        }
    }

    static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static void pro() {
        for (int i = 0; i < M; i++) {
            if(isNumeric(issue[i])) {
                sb.append(collections2.get(Integer.parseInt(issue[i]))).append("\n");
            } else{
                sb.append(collections.get(issue[i])).append("\n");
            }
        }
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
