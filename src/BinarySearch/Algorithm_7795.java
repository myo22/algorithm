package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm_7795 {
    static StringBuilder sb = new StringBuilder();

    static int lower_bound (int[] A, int L, int R, int X) {
        int result = L - 1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(A[mid] < X) {
                result = mid;
                L = mid + 1;
            } else if (A[mid] >= X) {
                R = mid -1;
            }
        }
        return result;
    }

    static void input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N + 1];
            B = new int[M + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            pro();
        }
    }

    static void pro() {
        Arrays.sort(B);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    static int T, N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        input();
    }
}
