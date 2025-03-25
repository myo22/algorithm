package PrefixSum;

import java.util.*;
import java.io.*;

public class Algorithm_19951 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각 지시에 따른 변화량을 기록한다.
        int[] delta = new int[N+2];
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            delta[a] += k;
            delta[b+1] -= k;
        }

        // 각 칸부터의 변화량을 각 칸에 적용한다.
        int[] accDelta = new int[N+1];
        for(int i = 1; i <= N; i++) {
            accDelta[i] = accDelta[i - 1] + delta[i];
        }

        // 변화량이 적용된 각 칸의 높이를 출력한다.
        for(int i = 1; i <= N; i++) {
            System.out.print(arr[i] + accDelta[i] + " ");
        }
    }
}
