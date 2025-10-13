package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm_10828 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] command;
    static Stack<Integer> stack;

    static void input() {
        N = scan.nextInt();
        command = new String[N];
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            command[i] = scan.nextLine();
        }
    }

    static void pro() {
        for (int i = 0; i < command.length; i++) {
            switch(command[i]) {
                case "top":
                    if(stack.empty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "pop":
                    if(stack.empty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case "empty":
                    if(stack.empty()) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                default:
                    String[] a = command[i].split(" ");
                    stack.push(Integer.parseInt(a[1]));
                    break;
            }
        }
    }

    public static void main(String[] args){
        input();
        pro();

        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
