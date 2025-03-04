package Sort;

import java.util.*;

public class Algorithm_1431 {
    static class Number {
        String number;
        int sum;

        Number (String number, int sum) {
            this.number = number;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Number[] serial = new Number[N];

        for(int i = 0; i < N; i++) {
            String number = sc.next();
            int sum = 0;
            for(int j = 0;  j < number.length(); j++) {
                char digit = number.charAt(j);
                if(Character.isDigit(digit)){
                    sum += (digit - '0');
                }
            }
            serial[i] = new Number(number, sum);
        }

        Arrays.sort(serial, new Comparator<Number>() {
            public int compare(Number o1, Number o2) {
                if(o1.number.length() != o2.number.length()) {
                    return o1.number.length() - o2.number.length();
                }else if(o1.number.length() == o2.number.length()) {
                    return o1.sum - o2.sum;
                }
                return o1.number.compareTo(o2.number);
            }
        });

        for(int i = 0; i < serial.length; i++) {
            System.out.println(serial[i].number);
        }

    }
}
