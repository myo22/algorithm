package Sort;

import java.util.*;
import java.io.*;

public class Algorithm_10814 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Main.Member> list = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            list.add(new Main.Member(sc.nextInt(), sc.next()));
        }

        list.sort(new Comparator<Main.Member>() {
            @Override
            public int compare(Main.Member o1, Main.Member o2) {
                return o1.key - o2.key;
            }
        });

        for (Main.Member member : list){
            System.out.println(member.key + " " + member.value);
        }

    }

    public static class Member {
        public Integer key;
        public String value;

        public Member(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
