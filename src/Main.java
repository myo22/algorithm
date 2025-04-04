import java.io.*;
import java.util.*;

class Main {
    static int findOptimalPair(int[] arr, int fromIndex, int toIndex ,int value) {
        int l = fromIndex, r = toIndex;
        int optimalPairValue = arr[fromIndex];
        int optimalAbs = 2000000000;

        while(l <= r) {
            int m = (l + r) / 2;
            int sum = arr[m] + value;

            if (Math.abs(sum) < optimalAbs) {
                optimalPairValue = arr[m];
                optimalAbs = Math.abs(sum);
            }

            if(sum < 0) {
                l = m + 1;
            }else if(sum > 0) {
                r = m - 1;
            }else{
                return m;
            }
        }
        return optimalPairValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ansAbs = Math.abs(arr[0] + arr[1]);
        int ans1 = arr[0], ans2 = arr[1];
        for(int i = 0; i < N - 1; i++) {
            int pairValue = findOptimalPair(arr, i + 1, N - 1, arr[i]);
            int sumAbs = Math.abs(arr[i] + pairValue);

            if(sumAbs < ansAbs) {
                ansAbs = sumAbs;
                ans1 = arr[i];
                ans2 = pairValue;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans1 + " " + ans2);
        bw.flush();
    }
}
