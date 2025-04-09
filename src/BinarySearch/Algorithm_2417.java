package BinarySearch;

import java.util.*;

public class Algorithm_2417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long q = (long) Math.sqrt(n);

        if(q * q >= n) {
            System.out.println(q);
        }else{
            q += 1;
            System.out.println(q);
        }
    }
}
