package BinarySearch;

import java.util.*;

public class Algorithm_2295 {
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

        // A + B + C = X -> A + B = X - C
        // 1. A + B의 집합을 만든다.
        int[] sums = new int[N * (N + 1) / 2];
        int sumIndex = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                sums[sumIndex++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sums);

        // 2. 모든 X - C에 대해 A + B 집합에 존재하는지 확인한다.
        int answer = -1;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                // if(Arrays.binarySearch(sums, target) >= 0)
                if(isExist(sums, target)){
                    answer = Math.max(answer, arr[i]);
                }
            }
        }
        // 3. A + B = X - C을 만족하는 X 중 최대값을 출력한다.
        System.out.println(answer);

    }

    // Set으로 푸는 방법
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        Set<Integer> set = new HashSet<>();
//
//        for(int i = 0; i < N; i++) {
//            for(int j = i; j < N; j++) {
//                set.add(arr[i] + arr[j]);
//            }
//        }
//
//        int answer = -1;
//        for (int i = 0; i < N; i++) {
//            for(int j = 0; j < N; j++) {
//                int target = arr[i] - arr[j];
//                if(set.contains(target)){
//                    answer = Math.max(answer, arr[i]);
//                }
//            }
//        }
//        System.out.println(answer);
//    }
}
