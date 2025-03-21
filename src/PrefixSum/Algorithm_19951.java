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
        for(int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int k =Integer.parseInt(st.nextToken());
            for(int i = a; i <= b; i++) {
                if(k >= 0) {
                    arr[i] += k;
                }
                arr[i] -= k;
            }
        }

    }
}
