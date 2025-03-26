import java.io.*;
import java.util.*;

class Main {
    static int[][] getPrefixSum(char[][] map) {
        int N = map.length - 1;
        int M = map[0].length - 1;
        int[][] acc = new int[N + 1][M + 1];

        for(int i = 1; i < map.length; i++) {
            for(int j = 1; j < map[0].length; j++) {
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1]
                        + (map[i][j] == '*' ? 1 : 0);
            }
        }
        return acc;
    }

    static int getRangeSum(int[][] acc, int r, int c, int K) {
        int r1 = Math.max(r - K, 1);
        int c1 = Math.max(c - K, 1);
        int r2 = Math.min(r + K, acc.length - 1);
        int c2 = Math.min(c + K, acc[0].length - 1);
        return acc[r2][c2] - acc[r1 - 1][c2] - acc[r2][c1 - 1] + acc[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int K = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        char[][] map = new char[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            String rowMap = sc.next();
            for(int j = 1; j <= M; j++) {
                map[i][j] = rowMap.charAt(j - 1);
            }
        }

        while(T-- > 0) {
            int[][] acc = getPrefixSum(map);
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    int nearAlive = getRangeSum(acc, i, j, K);
                    if(map[i][j] == '*') {
                        nearAlive--;
                        if(nearAlive < a || b < nearAlive) {
                            map[i][j] = '.';
                        }
                    }else{
                        if(a < nearAlive && nearAlive <= b) {
                            map[i][j] = '*';
                        }
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

//    // 간단하게 구현
//    static int getRangeSum(char[][] map, int r, int c, int K) {
//        int sum = 0;
//        for (int i = Math.max(r - K, 0); i <= Math.min(r + K, map.length - 1); i++) {
//            for(int j = Math.max(c - K, 0); j <= Math.min(c + K, map.length - 1); j++) {
//                if(map[i][j] == '*') {
//                    sum++;
//                }
//            }
//        }
//        return sum;
//    }
}
