package BinarySearch;

import java.util.*;

public class Algorithm_2417 {
    static boolean isIntegerSqrt(long N, long q) {
        return q * q >= N;
    }

    static long calcIntegerSqrt(long x) {
        if(x == 0){
            return 0;
        }

        long l = 1, r = 1L << 32, sqrt = -1;
        while(l <= r) {
            long m = (l + r) / 2;
            if (isIntegerSqrt(x, m)) {
                r = m - 1;
                sqrt = m;
            } else {
                l = m + 1;
            }
        }
        return sqrt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println(calcIntegerSqrt(n));
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        long n = sc.nextLong();
//        long q = (long) Math.sqrt(n);
//
//        if(isIntegerSqrt(n, q)) {
//            System.out.println(q);
//        }else{
//            q += 1;
//            System.out.println(q);
//        }
//    }
}
