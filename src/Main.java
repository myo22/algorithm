import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();

        double votes = X * 0.05;

        Map<Double, String> map = new HashMap<>();

        while(N-- > 0) {
            String name = sc.next();
            int score = sc.nextInt();

            if (score > votes) {
                for(int i = 1; i <= 14; i++){
                    map.put((double) score / i, name);
                }
            }
        }

        List<Double> list = new ArrayList<>(map.keySet());
        list.sort(Collections.reverseOrder());

        Map<String, Integer> answer = new HashMap<>();

        for(int i = 0; i < 14; i++){
            String key = map.get(list.get(i));
            answer.put(key, answer.getOrDefault(key, 0) + 1);
        }

        for(String key : answer.keySet()){
            System.out.println(key + " " + answer.get(key));
        }
    }
}
