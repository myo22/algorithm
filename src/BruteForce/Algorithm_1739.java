package BruteForce;

import java.util.Scanner;

public class Algorithm_1739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] board = new char[N][N];
        char[] chars = sc.next().toCharArray();

        int vertical  = 0;
        int horizon = 0;

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'U':
                    vertical--;
                    board[horizon][vertical] = 78;
                    break;
                case 'D':
                    vertical++;
                    board[horizon][vertical] = 78;
                    break;
                case 'L':
                    horizon--;
                    board[horizon][vertical] = 45;
                    break;
                case 'R':
                    horizon++;
                    board[horizon][vertical] = 45;
                    break;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + 46);
            }
            System.out.println();
        }
    }
}
