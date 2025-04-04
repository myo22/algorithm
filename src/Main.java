import java.io.*;
import java.util.*;

class Main {
    public static int isExist(int[] arr, int i, int k) {
        int r = i, l = arr.length - 1;
        int m = 0;
        while(r <= l) {
            m = (r + l) / 2;
            if(arr[m] + k < 0) {
                r = m + 1;
            }else if(arr[m] + k > 0) {
                l = m - 1;
            }else{
                return m;
            }
        }
        return m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 2000000000;
        int ansIndex1 = -1, ansIndex2 = -1;
        for(int i = 0; i < N; i++) {
            ansIndex1 = i;
            ansIndex2 = isExist(arr, i + 1, arr[i]);
            int property = Math.abs(arr[ansIndex1] + arr[ansIndex2]);
            if(property < answer) {
                answer = property;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(arr[ansIndex1] + " " + arr[ansIndex2]);
        bw.flush();
    }
}
