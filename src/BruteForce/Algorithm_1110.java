package BruteForce;

import java.util.Scanner;

public class Algorithm_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int originNumber = N;
        int sum = -1;
        int cnt = 0;

        while (sum != originNumber) {
            int middleSum = 0;
            int figure = N;

            while (N > 0) {
                middleSum += N % 10;
                N /= 10;
            }

            N = ((figure % 10) * 10) + (middleSum % 10);
            sum = N;
            cnt++;
        }

        System.out.println(cnt);
    }
}
