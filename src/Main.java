import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Member> list = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            list.add(new Member(sc.nextInt(), sc.next()));
        }

        list.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.key - o2.key;
            }
        });

        for (Member member : list){
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
