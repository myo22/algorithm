import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        int answer = -1;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if(set.contains(target)){
                    answer = Math.max(answer, arr[i]);
                }
            }
        }
        System.out.println(answer);
    }
}
