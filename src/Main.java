import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();

        double validCut = X * 0.05;
        boolean[] validCandidate = new boolean[26];
        int[] staffVote = new int[26];
        int candidateCount = 0;
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int vote = sc.nextInt();
            if (vote >= validCut) {
                int index = name.charAt(0) - 'A';
                validCandidate[index] = true;
                staffVote[index] = vote;
                candidateCount++;
            }
        }

        Score[] scores = new Score[candidateCount * 14];
        int scoreIndex = 0;
        for (int i = 0 ; i < 26; i++) {
            if (validCandidate[i]) {
                for (int j = 1; j <= 14; j++)
                    scores[scoreIndex++] = new Score(i, (double)staffVote[i] / j);
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

    public static void sortScoresDescendingOrder(Score[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < i; j++){
                if(arr[j].scr < arr[i].scr){
                    Score cur = arr[i];
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
