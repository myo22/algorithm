package Sort;

import java.util.*;
import java.io.*;

public class Algorithm_18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(house);

        int minDistance = house[(N-1) / 2];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(minDistance);
        bw.flush();
    }
}