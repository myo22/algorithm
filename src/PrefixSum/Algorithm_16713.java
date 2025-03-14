package PrefixSum;

import java.util.*;
import java.io.*;

public class Algorithm_16713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] Queries = new int[N + 1];
        Queries[0] = 0;
        for(int i = 1; i <= N; i++) {
            Queries[i] = Queries[i-1] ^ arr[i-1];
        }

        int[] answer = new int[Q];

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            answer[i] = Queries[e] ^ Queries[s-1];
        }

        int result = 0;
        for(int i = 0; i < Q; i++) {
            result ^= answer[i];
        }

        System.out.println(result);
    }
}
