package Sort;

import java.util.*;

public class Algorithm_10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<String, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < N; i++) {
            Integer value = sc.nextInt();
            String key = sc.next();
            map.put(key, value);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (String key : list){
            System.out.println(map.get(key) + " " +key);
        }

    }
}
