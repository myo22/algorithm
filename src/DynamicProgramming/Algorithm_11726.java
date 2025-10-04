package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm_11726 {
    static int N;
    static int[] Dy;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    static void pro(){
        Dy = new int[1001];
        Dy[1] = 1;
        Dy[2] = 2;

        for (int i = 3; i <= N; i++) {
            Dy[i] = (Dy[i-1] + Dy[i-2]) % 10007;
        }
        System.out.println(Dy[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
