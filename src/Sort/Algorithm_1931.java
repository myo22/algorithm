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

        Arrays.sort(meetings, (o1 , o2) -> o1.start - o2.start);

        int meetingIndex = meetings[0].start;
        int[] meetingCount = new int[meetings[N-1].end - 1];
        for(int i = 0; i < N; i++) {
            int count = 0;
            if(meetings[i].start != meetings[i].end) {
                meetingCount[++meetingIndex] = meetings[i].
            }
            meetingCount[meetingIndex]++;
        }

    }
}
