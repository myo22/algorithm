package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Algorithm_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] words = new String[N];

        for(int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for(int i = 0; i < N; i++) {
            System.out.println(words[i]);
        }
    }
}
