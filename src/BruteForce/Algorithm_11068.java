package BruteForce;

import java.util.Scanner;

public class Algorithm_11068 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        int[] arr = new int[T];

        for (int i = 0; i < T; i++) {
            arr[i] = in.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            String ans = "";
            boolean found = false;
            for(int j = 2; j <= 64; j++) {
                String answer = Integer.toString(arr[i], j).toUpperCase();
                if (isPalindrome(answer)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }

        }

        System.out.println(sb.toString());

    }

    private static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
