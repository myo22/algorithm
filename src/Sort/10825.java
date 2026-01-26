import java.io.IOException;

import java.io.*;
import java.util.*;

class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Student[] arr;

    static void input() {
        N = scan.nextInt();
        arr = new Student[N + 1];
        for (int i = 1; i <= N; i++) {
            String name = scan.next();
            int korean = scan.nextInt();
            int english = scan.nextInt();
            int math = scan.nextInt();
            arr[i] = new Student(name, korean, english, math);
        }
    }

    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        public Student (String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.korean != o.korean) {
                return o.korean - this.korean;
            } else if (this.english != o.english) {
                return this.english - o.english;
            } else if (this.math != o.math) {
                return o.math - this.math;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }

    static void pro() {
        Arrays.sort(arr, 1, N + 1);
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i].name).append("\n");
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
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