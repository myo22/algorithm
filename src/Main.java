import java.io.*;
import java.util.*;

class Main {
    static int findLowerBoundIndex(int[] arr, int x) {
        // x 이상의 값이 처음으로 나타나는 위치
        int lowerBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(arr[m] < x) {
                l = m + 1;
            }else{
                r = m - 1;
                lowerBoundIndex = m;
            }
        }
        return lowerBoundIndex;
    }

    static int findUpperBoundIndex(int[] arr, int x) {
        // x 초과의 값이 처음으로 나타나는 위치
        int UpperBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(arr[m] <= x) {
                l = m + 1;
            }else{
                r = m - 1;
                UpperBoundIndex = m;
            }
        }
        return UpperBoundIndex;
    }

    static int[] cardNumber = new int[20000001];
    static boolean isExist(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(arr[m] < k) {
                l = m + 1;
            }else if(arr[m] > k) {
                r = m - 1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(M-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            int lowerBoundIndex = findLowerBoundIndex(arr, x);
            int upperBoundIndex = findUpperBoundIndex(arr, x);
            bw.write(upperBoundIndex - lowerBoundIndex + " ");
        }

        bw.flush();
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int M = Integer.parseInt(br.readLine());
//        st = new StringTokenizer(br.readLine());
//        int[] card = new int[M];
//        for (int i = 0; i < M; i++) {
//            card[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int[] copiedCard = card.clone();
//
//        Arrays.sort(copiedCard);
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        for (int i = 0; i < N; i++) {
//            if(isExist(copiedCard, arr[i])) {
//                cardNumber[arr[i] + 10000000]++;
//            }
//        }
//
//        for (int i = 0; i < M; i++) {
//            bw.write(cardNumber[card[i] + 10000000] + " ");
//        }
//
//        bw.flush();
//    }
}
