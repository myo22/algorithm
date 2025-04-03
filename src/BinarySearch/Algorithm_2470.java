package BinarySearch;

import java.util.*;
import java.io.*;

public class Algorithm_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        int a = 0, b = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                int property = Math.abs(arr[i] + arr[j]);
                 if(property < answer) {
                     answer = property;
                     a = arr[i];
                     b = arr[j];
                 }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(a + " " + b);
        bw.flush();
    }
}
