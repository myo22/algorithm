package BruteForce;

import java.util.Scanner;

public class Algorithm_1120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        System.out.println(differenceString(A, B));


    }

    static int differenceString(String A, String B) {
        int count = 0;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) != B.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
