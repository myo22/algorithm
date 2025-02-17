import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> entered = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            String name = arr[0];
            String state = arr[1];
            if(state.equals("enter")) {
                entered.add(name);
            }
            else{
                entered.remove(name);
            }
        }

        String[] orderedAnswer = entered.toArray(new String[entered.size()]);
        for(int i = orderedAnswer.length - 1; i >= 0; i--){
            System.out.println(orderedAnswer[i]);
        }

    }
}
