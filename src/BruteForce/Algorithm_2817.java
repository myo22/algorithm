package BruteForce;

import java.util.*;

public class Algorithm_2817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();

        double validCut = X * 0.05;
        boolean[] validCandidate = new boolean[26];  // 유효한 후보인지 검증
        int[] staffVote = new int[26];
        int candidateCount = 0;
        for(int i = 0;  i < N; i++) {
            String name = sc.next();
            int vote = sc.nextInt();
            if (vote >= validCut) {
                int idx = name.charAt(0) - 'A';
                validCandidate[idx] = true;
                staffVote[idx] = vote;
                candidateCount++;
            }
        }

        Main.Score[] scores = new Main.Score[candidateCount * 14];
        int score_idx = 0;
        for (int i = 0; i < 26; i++) {
            if(!validCandidate[i]) continue; // 유효한 스태프여야만 기록
            for(int j = 0; j <= 14; j++){
                scores[score_idx++] = new Main.Score(i, (double)staffVote[i] / j);
            }
        }

        sortScoresDescendingOrder(scores);

        int[] ans = new int[26];
        for(int i = 0; i < 14; i++) {
            ans[scores[i].staffIndex]++;
        }

        for (int i = 0; i < 26; i++){
            if(validCandidate[i])
                System.out.println((char)('A' + i) + " " + ans[i]);
        }

    }

    public static void sortScoresDescendingOrder(Main.Score[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < i; j++){
                if(arr[j].scr < arr[i].scr){
                    Main.Score cur = arr[i];
                    for(int k = i; k > j; k--){
                        arr[k] = arr[k - 1];
                    }
                    arr[j] = cur;
                    break;
                }
            }
        }
    }

    static class Score{
        int staffIndex;
        double scr;

        public Score(int staffIndex, double scr) {
            this.staffIndex = staffIndex;
            this.scr = scr;
        }
    }
}
