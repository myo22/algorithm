import java.io.*;
import java.util.*;

class Main {
    // Sort로만 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] coordinate = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            coordinate[i][0] = x;
            coordinate[i][1] = i;
        }

        Arrays.sort(coordinate, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int idx = 0;
        int[] answer = new int[N];
        answer[coordinate[0][1]] = idx;
        for(int i = 1; i < N; i++) {
            if(coordinate[i - 1][0] != coordinate[i][0]){
                idx++;
            }
            answer[coordinate[i][1]] = idx;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++)
            bw.write(answer[i] + " ");
        bw.flush();
    }
}
