package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm_1015 {
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        int num, idx;

        @Override
        public int compareTo(Elem other) {
            return num - other.num;
        }
    }

    static void input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        B = new Elem[N];
        P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            B[i].num = Integer.parseInt(st.nextToken());
            B[i].idx = i;
        }
    }

    static void pro() {
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }

        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    static int N;
    static Elem[] B;
    static int[] P;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
