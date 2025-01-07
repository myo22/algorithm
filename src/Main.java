import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        char[] chars = sc.next().toCharArray();

        int vertical  = 0;
        int horizon = 0;

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'U':
                    board[horizon][vertical] |= 2;
                    board[horizon][--vertical] |= 2;
                    break;
                case 'D':
                    board[horizon][vertical] |= 2;
                    board[horizon][++vertical] |= 2;
                    break;
                case 'L':
                    board[horizon][vertical] |= 1;
                    board[--horizon][vertical] |= 1;
                    break;
                case 'R':
                    board[horizon][vertical] |= 1;
                    board[++horizon][vertical] |= 1;
                    break;
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char outputChar;
                if (board[j][i] == 3) {
                    outputChar = '+';
                } else if (board[j][i] == 2) {
                    outputChar = '|';
                } else if (board[j][i] == 1) {
                    outputChar = '-';
                } else {
                    outputChar = '.';
                }
                System.out.print(outputChar);
            }
            System.out.println();
        }
    }
}