package Sort;

import java.util.*;
import java.io.*;

public class Algorithm_1302 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] arr = new String[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr);

        int currentCount = 0;
        int maxCount = 0;
        String answer = "";
        for(int i = 0; i < arr.length - 1; i++){
            if(!arr[i].equals(arr[i+1])) {
                currentCount = 0;
            }
            currentCount++;

            if(maxCount < currentCount) {
                maxCount = currentCount;
                answer = arr[i];
            }
        }

        System.out.println(answer);

    }

//    // Map으로 풀어봤다.
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//
//        Map<String, Integer> map = new HashMap<>();
//
//        for(int i = 0; i < N; i++) {
//            String title = sc.next();
//            map.put(title, map.getOrDefault(title, 0) + 1);
//        }
//
//        List<String> list = new LinkedList<>(map.keySet());
//
//        int maxValue = 0;
//        String answer = "";
//
//        for(String title :list) {
//            if(map.get(title) > maxValue) {
//                maxValue = map.get(title);
//                answer = title;
//            }
//        }
//
//        System.out.println(answer);
//
//    }
    
}
