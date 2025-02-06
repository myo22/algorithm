package BruteForce;

import java.util.Scanner;

public class Algorithm_1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 각 줄에서 옮기면서 가장 작은 8개를 찾으면됨
        // 그걸 결국 줄마다 작은곳을 찾아서 마지막에 반환하면 되는거 아닌가?

        String white = "WBWBWBWB";
        String black = "BWBWBWBW";

        int answer = 0;

        for (int i = 0; i < N; i++) {
            String board = sc.nextLine();
            int sum = 8;

            for(int j = 0; j <= M - 8; j++){
                int cnt = 0;
                for(int k = 0; k < 8; k++){
                    if(white.charAt(k) != board.charAt(k + j)){
                        cnt++;
                    }
                }
                sum = Math.min(sum, cnt);
            }

            answer += sum;
        }

        System.out.println(answer);
    }
}
