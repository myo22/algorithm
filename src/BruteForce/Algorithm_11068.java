package BruteForce;

import java.util.Scanner;

public class Algorithm_11068 {

    public static int convertBase(int x, int base, int[] reverseDigit) {
        int len = 0;
        while (x > 0) {
            reverseDigit[len++] = x % base;
            x /= base;
        }
        return len;
    }

    public static boolean isPalindrome(int[] digit, int length) {
        for (int i = 0; i < length / 2; i++) {
            if (digit[i] != digit[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T-- > 0) {
            int x = in.nextInt();
            boolean ans = false;
            for(int j = 2; j <= 64; j++) {
                int[] baseDigit = new int[20];
                int baseLength = convertBase(x, j, baseDigit);
                if (isPalindrome(baseDigit, baseLength)) {
                    ans = true;
                    break;
                }
            }
            System.out.println(ans ? "1" : "0");
        }
    }
}
