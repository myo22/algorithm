import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] acc = new int[N + 1];
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += arr[i - 1];
            acc[i] = sum;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.write(acc[j] - acc[i - 1] + "\n");
        }
        bw.flush();
    }
}
