package Sort;

import java.io.*;
import java.util.*;

public class Algorithm_2910 {
    static class Frequency {
        int num;
        int count;
        int firstIndex;

        Frequency(int num, int count, int firstIndex) {
            this.num = num;
            this.count = count;
            this.firstIndex = firstIndex;
        }
    }

    static class Message {
        int num;
        int idx;

        Message (int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Message[] messages = new Message[N];
        for(int i = 0; i < N; i++) {
            messages[i] = new Message(Integer.parseInt(st.nextToken()), i);
        }


        Arrays.sort(messages, (o1, o2) -> o1.num - o2.num);

        Frequency[] frequencies = new Frequency[N];
        int frequencyIndex = 0;
        frequencies[0] = new Frequency(messages[0].num, 1, messages[0].idx);
        for(int i = 1; i < messages.length; i++){
            if(messages[i].num != messages[i].num) {
                frequencies[++frequencyIndex] = new Frequency(messages[0].num, 1, messages[0].idx);
            }
            frequencies[frequencyIndex].count++;
        }

        Arrays.sort(frequencies, new Comparator<Frequency>() {
            @Override
            public int compare(Frequency o1, Frequency o2){
                if(o1.count != o2.count) {
                    return o2.count - o1.count;
                }
                return o1.firstIndex - o2.firstIndex;
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Frequency frequency : frequencies){
            bw.write(frequency.num + " ");
        }
        bw.flush();
    }
}
