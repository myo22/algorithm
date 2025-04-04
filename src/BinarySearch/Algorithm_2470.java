package BinarySearch;

import java.util.*;
import java.io.*;

public class Algorithm_2470 {
    public static int isExist(int[] arr, int i, int k) {
        int l = i, r = arr.length - 1;
        int closestIndex = i;
        int minDiff = Integer.MAX_VALUE;

        while(l <= r) {
            int m = (l + r) / 2;
            int sum = arr[m] + k;

            // 최소 절댓값 비교
            if (Math.abs(sum) < minDiff) {
                minDiff = Math.abs(sum);
                closestIndex = m;
            }

            if(sum < 0) {
                l = m + 1;
            }else if(sum > 0) {
                r = m - 1;
            }else{
                return m;
            }
        }
        return closestIndex;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 2000000000;
        int ansIndex1 = -1, ansIndex2 = -1;
        for(int i = 0; i < N - 1; i++) {
            int idx2 = isExist(arr, i + 1, arr[i]);
            int property = Math.abs(arr[i] + arr[idx2]);

            if(property < answer) {
                answer = property;
                ansIndex1 = i;
                ansIndex2 = idx2;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(arr[ansIndex1] + " " + arr[ansIndex2]);
        bw.flush();
    }
}
