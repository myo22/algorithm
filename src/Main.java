import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1. 보드에 좌표식으로 색상을 입력
        char[][] board = new char[N][N];
        for(int i = 0; i < N; i++) {
            String color = sc.next();
            for(int j = 0; j < N; j++) {
                board[i][j] = color.charAt(j);
            }
        }

        // 최대 사탕 개수 저장
        int maxCandy = 0;

        // 2. 현재 보드에서 최대 사탕 개수 확인
        for (int i = 0; i < N; i++) {
            maxCandy = Math.max(maxCandy, checkRow(board, i, N));
            maxCandy = Math.max(maxCandy, checkColumn(board, i, N));
        }

        // 3. 인접한 칸 교환 후 최대 사탕 개수 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽과 교환
                if (j + 1 < N && board[i][j] != board[i][j+1]) {
                    swap(board, i, j, i, j + 1);
                    maxCandy = Math.max(maxCandy, checkRow(board, i, N));
                    maxCandy = Math.max(maxCandy, checkColumn(board, j, N));
                    maxCandy = Math.max(maxCandy, checkColumn(board, j + 1, N));
                    swap(board, i, j, i, j + 1); // 복구
                }

                // 아래쪽과 교환
                if (i + 1 < N && board[i][j] != board[i + 1][j]) {
                    swap(board, i, j, i + 1, j);
                    maxCandy = Math.max(maxCandy, checkColumn(board, j, N));
                    maxCandy = Math.max(maxCandy, checkRow(board, i, N));
                    maxCandy = Math.max(maxCandy, checkRow(board, i + 1, N));
                    swap(board, i, j, i + 1, j); // 복구
                }
            }
        }

        System.out.println(maxCandy);
    }

    // 행에서 최대 사탕 개수 계산
    private static int checkRow(char[][] board, int row, int N) {
        int count = 1, maxCount = 1;
        for (int j = 1; j < N; j++) {
            if (board[row][j] == board[row][j - 1]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 1;
            }
        }
        return maxCount;
    }
    // 열에서 최대 사탕 개수 계산
    private static int checkColumn(char[][] board, int col, int N) {
        int count = 1, maxCount = 1;
        for (int i = 1; i < N; i++) {
            if (board[i][col] == board[i - 1][col]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 1;
            }
        }
        return maxCount;
    }

    // 두 칸을 교환
    private static void swap(char[][] board, int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}