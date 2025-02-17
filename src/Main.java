import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            map.put(arr[0], arr[1]);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.removeIf(answer -> map.get(answer).equals("leave"));

        Collections.sort(list, Collections.reverseOrder());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(String answer : list) {
            bw.write(answer);
        }

        bw.flush();
    }
}
