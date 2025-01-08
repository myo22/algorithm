package BruteForce;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Algorithm_2840 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');
        boolean isPossible = true;
        Map<Character, Integer> seen = new HashMap<>();

        int currentPos = 0;

        while (K-- > 0) {
            int S = sc.nextInt();
            char letter = sc.next().charAt(0);

            currentPos  = (currentPos + S) % N;

            if(wheel[currentPos] != '?' || wheel[currentPos] != letter) {
                isPossible = false;
                break;
            }

            if(seen.containsKey(letter) && seen.get(letter) != currentPos) {
                isPossible = false;
                break;
            }

            wheel[currentPos] = letter;
            seen.put(letter, currentPos);

            // 모순이 있으면 에러 메시지 출력
            if (!isPossible) {
                System.out.println("!");
                return;
            }

            // 결과 출력
            for (char c : wheel) {
                System.out.print(c);
            }

        }
    }
}
