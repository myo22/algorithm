package BruteForce;

import java.io.*;
import java.util.*;

public class Algorithm_15651 {
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int [M + 1];
    }

    static int N, M;
    static int[] selected;

    // 만약 M 개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것
    // 아직 M 개를 고르지 않음 => k 번째부터 N번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else{
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }
}
