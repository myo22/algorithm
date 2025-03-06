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

        double meDistance = (house[0] + house[N - 1]) / 2.0;

        double min = meDistance;
        int result = 0;
        for(int i = 1; i < N - 1; i++) {
           double minDistance = Math.abs(house[i] - meDistance);
           if(min > minDistance) {
                min = minDistance;
                result = house[i];
           }
        }

        System.out.println(result);

    }
}