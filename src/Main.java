import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int H = in.nextInt();
            int W = in.nextInt();
            int N = in.nextInt();

            int roomCount = 0;
            boolean found = false;
            outer:
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < H; k++) {
                    roomCount++;
                    if (roomCount >= N) {
                        System.out.println(String.valueOf(k + 1) + String.format("%02d", j + 1));
                        break outer;  // 레이블을 이용해 바깥 루프도 종료
                    }
                }
            }

        }
    }
}