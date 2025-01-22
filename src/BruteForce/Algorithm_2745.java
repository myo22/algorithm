package BruteForce;

import java.util.Scanner;

public class Algorithm_2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();
        int sum = 0;
        int a;

        for(int i = 0; i < N.length(); i++){
            char ch = N.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                a = ch - 55;
            }else{
                a = ch - '0';
            }
            sum += a * Math.pow(B, i);
        }

        System.out.println(sum);
    }
}
