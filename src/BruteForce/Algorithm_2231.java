package BruteForce;

import java.util.Scanner;

public class Algorithm_2231{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum;
        for(int i = N / 2; i < N; i++){
            sum = i;
            while (i > 0){
                sum += i % 10;
                i /= 10;
            }
            if(sum == N){
                System.out.println(i);
                break;
            }
        }
        System.out.println("0");
    }
}
