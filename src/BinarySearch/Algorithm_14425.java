package BinarySearch;

import java.util.*;

public class Algorithm_14425 {
    public static boolean isExist(String[] arr, String x) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            int result = arr[m].compareTo(x);
            if(result < 0) {
                l = m + 1;
            }else if(result > 0) {
                r = m - 1;
            }
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        // 1. Binary Search를 적용시키기 위해 정렬한다.
        Arrays.sort(arr);

        int count = 0;
        while(M-- > 0) {
            String a = sc.next();
//            if(Arrays.binarySearch(arr, a) >= 0){
//                count++;
//            }
            // 2. arr에 a가 있는지 확인한다.
            if(isExist(arr, a)){
                count++;
            }
        }

        System.out.println(count);
    }

    // Set을 이용한 방법
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//
//        Set<String> set = new HashSet<>();
//        while(N--> 0) {
//            set.add(sc.next());
//        }
//
//        int count = 0;
//        while(M-- > 0) {
//            if(set.contains(sc.next())){
//                count++;
//            }
//        }
//
//        System.out.println(count);
//    }
}
