package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm_10825 {
    static StringBuilder sb = new StringBuilder();

    static void input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        student = new Student[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            student[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    static void pro() {
        Arrays.sort(student);

        for (int i = 0; i < student.length; i++) {
            sb.append(student[i].name).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Student implements Comparable<Student> {

        String name;
        int korean;
        int english;
        int math;

        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (korean != o.korean) {
                return o.korean - this.korean;
            }
            if (english != o.english) {
                return this.english - o.english;
            }
            if (math != o.math) {
                return o.math - this.math;
            }
            return this.name.compareTo(o.name);
        }
    }

    static int N;
    static Student[] student;

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
