package Sort;

import java.util.*;

public class Algorithm_10814 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Member[] members = new Member[N];

        for(int i = 0; i < N; i++) {
            members[i] = (new Member(sc.nextInt(), sc.next(), i));
        }

        Arrays.sort(members);

        for (Member member : members){
            System.out.println(member.key + " " + member.value);
        }

    }

    static class Member implements Comparable<Member>{
        public Integer key;
        public String value;
        int idx;

        public Member(int key, String value, int idx){
            this.key = key;
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Member o) {
            if(this.key == o.key){
                return this.key- o.key;
            }
            return this.idx - o.idx;
        }
    }
}
