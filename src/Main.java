import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> messages = new LinkedHashMap<>();
        for(int i = 0; i < N; i++) {
            int message =  Integer.parseInt(st.nextToken());
            messages.put(message, messages.getOrDefault(message, 0) + 1);
        }

        Integer[] frequencies = messages.keySet().toArray(new Integer [messages.size()]);
        Arrays.sort(frequencies, (o1, o2) -> messages.get(o2) - messages.get(o1));


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Integer frequency: frequencies) {
            int count = messages.get(frequency);
            while(count-- > 0){
                bw.write(frequency + " ");
            }
        }
        bw.flush();
    }
}
