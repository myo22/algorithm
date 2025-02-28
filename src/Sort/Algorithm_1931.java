package Sort;

import java.io.*;
import java.util.*;

public class Algorithm_1931 {

    static class Meeting {
        int start;
        int end;

        Meeting (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Meeting[] meetings = new Meeting[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings, new Comparator<Meeting>(){
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        int count = 0, endtime = 0;
        for(int i = 0; i < N; i++) {
            if(meetings[i].start >= endtime) {
                count++;
                endtime = meetings[i].end;
            }
        }
        System.out.println(count);
    }
}
