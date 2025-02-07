import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String A = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = A.charAt(j);
            }
        }

        int minChange = Integer.MAX_VALUE;

        // 8x8 체스판을 만들 수 있는 모든 시작점 탐색
        for (int startRow = 0; startRow <= N - 8; startRow++) {
            for (int startCol = 0; startCol <= M - 8; startCol++) {
                minChange = Math.min(minChange, countChanges(board, startRow, startCol));
            }
        }

        System.out.println(minChange);
    }

    static int countChanges(char[][] board, int startRow, int startCol) {
        // 체스판 패턴 2가지
        char[][] whiteFirst = {
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
        };

        char[][] blackFirst = {
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
        };

        int whiteCount = 0;
        int blackCount = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[startRow + i][startCol + j] != whiteFirst[i][j]) whiteCount++;
                if (board[startRow + i][startCol + j] != blackFirst[i][j]) blackCount++;
            }
        }

        return Math.min(whiteCount, blackCount);
    }
}
