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

        int[] delta = new int[N+2];
        int[] accDelta = new int[N+1];
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            delta[a] += k;
            delta[b+1] -= k;
        }

        int a = delta[1];
        for(int i = 1; i <= N; i++) {
            accDelta[i] = accDelta[i - 1] + delta[i];
        }

        for(int i = 0; i <= N; i++) {
            arr[i] = arr[i] + accDelta[i];
        }

        for(int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
