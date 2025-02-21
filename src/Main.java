import java.io.*;
import java.util.*;

class Main {
    // Sort로만 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] originCoordinate = new int[N];
        int[] coordinate = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            coordinate[i] = x;
            originCoordinate[i] = x;
        }

        Arrays.sort(coordinate);

        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        for(int i = 1; i < N; i++) {
            map.put(coordinate[i-1], idx);
            if(coordinate[i - 1] != coordinate[i]){
                idx++;
            }
        }

        for(int x : originCoordinate) {
            System.out.print(map.get(x) + " ");
        }
    }
}
