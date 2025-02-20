import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String title = sc.next();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        List<String> list = new LinkedList<>(map.keySet());

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        int maxValue = 0;
        String answer = "";

        for(String title :list) {
            if(map.get(title) > maxValue) {
                maxValue = map.get(title);
                answer = title;
            }
        }

        System.out.println(answer);

    }
}
