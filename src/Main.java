import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Student[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new Student[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
    }

    static class Student implements Comparable<Student>{
        public String name;
        public int Korean, English, Math;

        public Student(String name, int Korean, int English, int Math) {
            this.name = name;
            this.Korean = Korean;
            this.English = English;
            this.Math = Math;
        }

        @Override
        public int compareTo(Student o) {
            if(Korean != o.Korean) {
                return o.Korean - Korean;
            }
            if(English != o.English) {
                return English - o.English;
            }
            if(Math != o.Math) {
                return o.Math - Math;
            }
            return name.compareTo(o.name);
        }
    }

    static void pro() {
        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            sb.append(arr[i].name).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();

        System.out.println(sb.toString());
    }
}
