package Sort;

import java.io.*;
import java.util.*;

public class Algorithm_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Integer[][] arr = new Integer[N][3];
        for(int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2){
                return o1[0] - o2[0];
            }
        });

        int[] count = new int[C];
        int idx = 0;
        for(int i = 1; i < N - 1; i++){
            if(arr[i][0] != arr[i - 1][0]) {
                count[arr[i][0]] = idx;
            }
            idx++;
        }

        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2){
                if(count[o1[0]] != count[o2[0]]) {
                    return count[o1[0]] - count[o2[0]];
                }
                return o1[1] - o2[1];
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++){
            bw.write(arr[i][0] + " ");
        }
        bw.flush();
    }
}
