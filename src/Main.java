import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 각 줄에서 옮기면서 가장 작은 8개를 찾으면됨
        // 그걸 결국 줄마다 작은곳을 찾아서 마지막에 반환하면 되는거 아닌가?

        // 첫번째가 white 시작인경우
        // 첫번째가 black 시작인경우

        String white = "WBWBWBWB";
        String black = "BWBWBWBW";

        int answer = 0;

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String A = sc.next();
            for(int j = 0; j < M; j++) {
                board[i][j] = A.charAt(j);
            }
        }

        int sum = 16;

        for(int j = 0; j < 8; j++) {
            int cnt = 0;
            for(int k = 0; k < 8 - j - 1; k++){
                if(board[j][k] == board[j][k+1]){
                    cnt++;
                }
            }

            for(int k = 0; k < 8 - j - 1; k++){
                if(board[k][j] == board[k+1][j]){
                    cnt++;
                }
            }

            sum = Math.min(sum, cnt);
        }


        answer += sum;

        System.out.println(answer);
    }

}
