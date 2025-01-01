import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int H = in.nextInt();
            int W = in.nextInt();
            int N = in.nextInt();

            int distance = (N - 1) / H + 1;
            int floor = (N - 1) % H + 1;
            System.out.printf("%d%02d\n",floor, distance);
        }
    }
}