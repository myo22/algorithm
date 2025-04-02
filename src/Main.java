import java.util.*;

class Main {
    public static boolean isExist(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(arr[m] < k) {
                l = m + 1;
            }else if(arr[m] > k) {
                r = m - 1;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int d = 0;
        for (int x = 0; x < N - 1; x++) {
            for(int y = 0; y < N - 1; y++) {
                for(int z = 0; z < N - 1; z++) {
                    int k = arr[x] + arr[y] + arr[z];
                    if(isExist(arr, k) && k > d){
                        d = k;
                    }
                }
            }
        }
        System.out.println(d);
    }
}
