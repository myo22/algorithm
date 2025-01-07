package BruteForce;

import java.util.Scanner;

public class Algorithm_1730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String command = sc.next();

        boolean[][] passVertical= new boolean[N][N];
        boolean[][] passHorizontal= new boolean[N][N];

        int curR = 0, curC = 0;

        for(int i = 0; i < command.length(); i++) {
            char cmd = command.charAt(i);
            if(cmd == 'D') {
                if (curR == N - 1) {
                    continue;
                }
                passVertical[curR][curC]  = passHorizontal[curR + 1][curC] = true;
                curR++;
            }else if (cmd == 'U') {
                if (curR == 0) {
                    continue;
                }
                passVertical[curR][curC]  = passHorizontal[curR - 1][curC] = true;
                curR--;
            }else if (cmd == 'L') {
                if (curC == 0){
                    continue;
                }
                passHorizontal[curR][curC] = passVertical[curR][curC - 1] = true;
                curC--;
            }else if(cmd == 'R') {
                if (curC == N - 1){
                    continue;
                }
                passHorizontal[curR][curC] = passVertical[curR][curC + 1] = true;
                curC++;
            }
        }

        for(int i = 0; i < N; i++) {
            String ans = "";
            for (int j = 0; j < N; j++) {
                if(passVertical[i][j] && passHorizontal[i][j]) {
                    ans += "+";
                }else if(passVertical[i][j]){
                    ans += "|";
                }else if(passHorizontal[i][j]){
                    ans += "-";
                }else
                    ans += ".";
            }
            System.out.println(ans);
        }
    }
}
