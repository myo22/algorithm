package Sort;

import java.io.*;
import java.util.*;

public class Algorithm_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            map.put(arr[0], arr[1]);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.removeIf(answer -> map.get(answer).equals("leave"));

        Collections.sort(list, Collections.reverseOrder());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (String answer : list) {
            bw.write(answer + "\n");
        }

        bw.flush();
    }


    // 2.  Sort를 활용한 방법
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        String[][] records = new String[n][2];
//        for (int i = 0; i < n; i++) {
//            String[] arr = br.readLine().split(" ");
//            records[i][0] = arr[0];
//            records[i][1] = arr[1];
//        }
//
//        Arrays.sort(records, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return o2[0].compareTo(o1[0]);
//            }
//        });
//
//        for (int i = 0; i < n - 1; i++) {
//            if (records[i][1].equals("enter") && !records[i][0].equals(records[i + 1][0])) {
//                System.out.println(records[i][0]);
//            }
//        }
//
//        if (records[n - 1][1].equals("enter")) {
//            System.out.println(records[n - 1][0]);
//        }
//
//    }

    // 3. Set을 이용한 방법
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        Set<String> entered = new TreeSet<>();
//        for (int i = 0; i < n; i++) {
//            String[] arr = br.readLine().split(" ");
//            String name = arr[0];
//            String state = arr[1];
//            if(state.equals("enter")) {
//                entered.add(name);
//            }
//            else{
//                entered.remove(name);
//            }
//        }
//
//        String[] orderedAnswer = entered.toArray(new String[entered.size()]);
//        for(int i = orderedAnswer.length - 1; i >= 0; i--){
//            System.out.println(orderedAnswer[i]);
//        }
//
//    }

}