package BruteForce;

public class Algorithm_4673 {
    public static void main(String[] args) {
        boolean[] selfNumber = new boolean[20000];
        int origin;
        int sum;
        for(int i = 1; i <= 10000; i++) {
            origin = i;
            sum = i;
            while(origin > 0) {
                sum += origin % 10;
                origin /= 10;
            }
            selfNumber[sum] = true;
        }

        for(int i = 1; i <= 10000; i++) {
            if(!selfNumber[i]) {
                System.out.println(i);
            }
        }

    }
}
