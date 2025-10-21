package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Algorithm_17479 {
    static FastReader scan = new FastReader();

    static int A, B, C, N;
    static long sum = 0;
    static StringBuilder sb;
    static Map<String, Integer> normal  = new HashMap<>();
    static Map<String, Integer> special  = new HashMap<>();
    static Map<String, String> service = new HashMap<>();
    static String[] order;

    static void input() {
        sb = new StringBuilder();
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();
        for (int i = 0; i < A; i++) {
            normal.put(scan.next(),  scan.nextInt());
        }
        for (int i = 0; i < B; i++) {
            special.put(scan.next(),  scan.nextInt());
        }
        for (int i = 0; i < C; i++) {
            service.put(scan.next() , " ");
        }
        N = scan.nextInt();
        order = new String[N];
        for (int i = 0; i < N; i++) {
            order[i] = scan.next();
        }
    }

    static void pro() {
        long totalGeneral = 0L;
        long totalSpecial = 0L;
        int serviceCount = 0;

        // 1) 전체 주문을 먼저 집계하면서 '존재하지 않는 메뉴' 여부 체크
        for (int i = 0; i < N; i++) {
            String name = order[i];
            if (normal.containsKey(name)) {
                totalGeneral += normal.get(name);
            } else if (special.containsKey(name)) {
                totalSpecial += special.get(name);
            } else if (service.containsKey(name)) {
                serviceCount++;
            } else {
                sb.append("No");
                return;
            }
        }

        if (totalSpecial > 0 && totalGeneral < 20000L) {
            sb.append("No");
            return;
        }

        if (serviceCount > 1) {
            sb.append("No");
            return;
        }
        if (serviceCount == 1 && (totalGeneral + totalSpecial) < 50000L) {
            sb.append("No");
            return;
        }

        sb.append("Okay");
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