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
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);

        int[][] frequencies = new int[arr.length][2];
        int frequencyIndex = 0;
        frequencies[frequencyIndex][0] = arr[0];
        frequencies[frequencyIndex][1] = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i - 1]) {
                frequencies[++frequencyIndex][0] = arr[i];
            }
            frequencies[frequencyIndex][1]++;
        }

        Arrays.sort(frequencies, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1] - o1[1];
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i <= frequencyIndex; i++) {
            for(int j = 0; j < frequencies[i][1]; j++){
                bw.write(frequencies[i][0] + " ");
            }
        }
        bw.flush();
    }
}
