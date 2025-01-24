package BruteForce;

import java.util.Scanner;

public class Algorithm_1233 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S1 = sc.nextInt();
        int S2 = sc.nextInt();
        int S3 = sc.nextInt();

        int sum = S1 + S2 + S3;

        int[] figure = new int[sum+1];

        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    figure[i+j+k]++;
                }
            }
        }

        int answer = 0;

        for (int i = 3; i <= sum; i++) {
            int max = 0;
            if(figure[i] > max) {
                max = figure[i];
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
