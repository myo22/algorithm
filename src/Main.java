import java.util.*;

class Main {
    public static boolean isExist(int[] arr, int K) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(arr[m] < K) {
                l = m + 1;
            } else if(arr[m] > K) {
                r = m - 1;
            } else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int K = sc.nextInt();
            boolean ans = isExist(arr, K);
            System.out.println(ans ? 1 : 0);
        }
    }
}
