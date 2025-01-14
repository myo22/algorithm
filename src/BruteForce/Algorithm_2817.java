package BruteForce;

import java.util.*;

public class Algorithm_2817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();

        double votes = X * 0.05;

        List<StaffScore> scores = new  ArrayList<>();
        Set<String> allNames = new HashSet<>();

        while(N-- > 0) {
            String name = sc.next();
            int score = sc.nextInt();

            if (score >= votes) {
                for(int i = 1; i <= 14; i++){
                    scores.add( new StaffScore(name, (double) score/i));
                    allNames.add(name);
                }
            }
        }

        scores.sort(new Comparator<StaffScore>(){
            @Override
            public int compare(StaffScore a, StaffScore b) {
                return (int) (b.score - a.score);
            }
        });

        Map<String, Integer> chipcount = new HashMap<>();
        for (String name : allNames) {
            chipcount.put(name, 0);
        }

        for(int i = 0; i < 14 && i < scores.size(); i++){
            String name = scores.get(i).name;
            chipcount.put(name, chipcount.getOrDefault(name, 0) + 1);
        }

        List<String> resultNames = new ArrayList<>(chipcount.keySet());
        Collections.sort(resultNames);

        for(String name : resultNames){
            System.out.println(name + " " + chipcount.get(name));
        }
    }

    public static class StaffScore{
        public String name;
        public double score;

        public StaffScore(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }

//    // 다른 풀이
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int X = sc.nextInt();
//        int N = sc.nextInt();
//
//        int[] staffVote = new int[26];
//
//        boolean[] validCandidate = new boolean[26];  // 유효한 후보인지 검증
//        double validCut = X * 0.05;
//        int candidateCount = 0;
//        for(int i = 0;  i < N; i++) {
//            String name = sc.next();
//            int vote = sc.nextInt();
//            if (vote >= validCut) {
//                int idx = name.charAt(0) - 'A';
//                validCandidate[idx] = true;
//                staffVote[idx] = vote;
//                candidateCount++;
//            }
//        }
//
//        Main.Score[] scores = new Main.Score[candidateCount * 14];
//        int score_idx = 0;
//        for (int i = 0; i < 26; i++) {
//            if(!validCandidate[i]) continue; // 유효한 스태프여야만 기록
//            for(int j = 0; j <= 14; j++){
//                scores[score_idx++] = new Main.Score(i, (double)staffVote[i] / j);
//            }
//        }
//
//        sortScoresDescendingOrder(scores);
//
//        int[] ans = new int[26];
//        for(int i = 0; i < 14; i++) {
//            ans[scores[i].staffIndex]++;
//        }
//
//        for (int i = 0; i < 26; i++){
//            if(validCandidate[i])
//                System.out.println((char)('A' + i) + " " + ans[i]);
//        }
//
//    }
//
//    public static void sortScoresDescendingOrder(Main.Score[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for(int j = 0; j < i; j++){
//                if(arr[j].scr < arr[i].scr){
//                    Main.Score cur = arr[i];
//                    for(int k = i; k > j; k--){
//                        arr[k] = arr[k - 1];
//                    }
//                    arr[j] = cur;
//                    break;
//                }
//            }
//        }
//    }
//
//    static class Score{
//        int staffIndex;
//        double scr;
//
//        public Score(int staffIndex, double scr) {
//            this.staffIndex = staffIndex;
//            this.scr = scr;
//        }
//    }
}
