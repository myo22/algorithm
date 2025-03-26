package PrefixSum;

import java.util.*;
import java.io.*;

public class Algorithm_17232 {
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
                map[i][j] = rowMap.charAt(j-1);
            }
        }

        while(T-- > 0) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    int nearAlive = getRangeSum(map, i, j, K);
                    if(map[i][j] == '*') {
                        nearAlive--;
                        if(nearAlive < a || b < nearAlive) {
                            map[i][j] = '.';
                        }
                    }else{
                        if(nearAlive > a && nearAlive <= b) {
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

    static int getRangeSum(char[][] map, int r, int c, int K) {
        int sum = 0;
        for (int i = Math.max(r - K, 0); i <= Math.min(r + K, map.length - 1); i++) {
            for(int j = Math.max(c - K, 0); j <= Math.min(c + K, map.length - 1); j++) {
                if(map[i][j] == '*') {
                    sum++;
                }
            }
        }
        return sum;
    }
}
