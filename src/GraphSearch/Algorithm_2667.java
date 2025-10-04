package GraphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithm_2667 {
    static StringBuilder sb = new StringBuilder();

    static int N, group_cnt;
    static List<Integer> group;
    static String[] a;
    static int[][] dir = {{1, 0}, {0, 1}, {-1 , 0}, {0, -1}};
    static boolean[][] visit;

    static void input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }
        visit = new boolean[N][N];
    }

    static void dfs (int x, int y) {
        group_cnt++;
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || ny >= N | nx >= N) {
                continue;
            }
            if (a[nx].charAt(ny) == '0') {
                continue;
            }
            if (visit[nx][ny]) {
                continue;
            }
            dfs(nx, ny);
        }
    }


    static void pro() {
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }

        Collections.sort(group);
        sb.append(group.size()).append("\n");
        for (int cnt : group) {
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}