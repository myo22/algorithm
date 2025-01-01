package BruteForce;

import java.util.Scanner;

public class Algorithm_10250 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int H = in.nextInt();
            int W = in.nextInt();
            int N = in.nextInt();

            int count = 0;
            boolean found = false;
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < H; k++) {
                    count++;
                    if (count >= N) {
                        System.out.println(String.valueOf(k + 1) + (j < 10 ? "0" +String.valueOf(j + 1) : String.valueOf(j + 1)));
                        found = true; // 플래그 설정
                        break; // 안쪽 루프 종료
                    }
                }
                if (found) break; // 바깥 루프 종료
            }

        }

    }
}
