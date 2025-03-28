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

    // 이분 탐색으로 푸는 방법
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
            // 직접 구현을 안하더라도 구할 수 있다.
//            boolean ans = isExist(arr, K);
            int ans = Arrays.binarySearch(arr, K);
            System.out.println(ans >= 0 ? 1 : 0);
        }
    }

//    // Set으로 푸는 방법
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        Set<Integer> set = new HashSet<>();
//        for(int i = 0; i < N; i++) {
//            set.add(sc.nextInt());
//        }
//
//        int M = sc.nextInt();
//        for(int i = 0; i < M; i++) {
//            int K = sc.nextInt();
//            System.out.println(set.contains(K) ? 1 : 0);
//        }
//    }
}
