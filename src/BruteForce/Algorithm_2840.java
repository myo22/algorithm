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
        int curIndex = 0;

        while (K-- > 0) {
            int S = sc.nextInt(); // 시계방향으로 S만큼 이동
            char nextAlphabet = sc.next().charAt(0);

            // 화살표가 어느 인덱스를 가르키고 있는지 기록
            int nextIndex = ((curIndex - S) % N + N) % N; // 빼는 이유는 바퀴의 방향과 화살표의 방향이 반대이기 떄문이다.
            if(wheel[nextIndex] == '?') {
                wheel[nextIndex] = nextAlphabet;
            }else if(wheel[nextIndex] != nextAlphabet) {
                System.out.print('!');
                return;
            }
            curIndex = nextIndex; // 현재 화살표의 위치
        }

        // 바퀴에 적힌 글자가 모두 다른지 확인
        boolean[] isExist = new boolean[26];
        for(int i = 0; i < N; i++) {
            if(wheel[i] == '?') {
                continue;
            }
            if (isExist[wheel[i] - 'A']) {
                System.out.print('!');
                return;
            }
            isExist[wheel[i] - 'A'] = true; // 아스키 코드 값을 이용해서 0부터 시작하는 인덱스로 기록
        }

        for(int i = 0; i < N; i++) {
            System.out.print(wheel[(curIndex + i) % N]); // 마지막 바퀴의 글자부터 출력해야한다.
        }
        System.out.println();
    }
}
