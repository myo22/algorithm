package BinarySearch;

import java.util.*;

public class Algorithm_14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Set<String> set = new HashSet<>();
        while(N--> 0) {
            set.add(sc.next());
        }

        int count = 0;
        while(M-- > 0) {
            if(set.contains(sc.next())){
                count++;
            }
        }

        System.out.println(count);
    }
}
