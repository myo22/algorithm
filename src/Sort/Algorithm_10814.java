package Sort;

import java.util.*;
import java.io.*;

public class Algorithm_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            Integer value = Integer.parseInt(s.split(" ")[0]);
            String key = s.split(" ")[1];
            map.put(key, value);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (String key : list){
            bw.write(map.get(key) + " " +key + "\n");
        }

        bw.flush();
    }
}
