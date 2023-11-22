package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_10431 {

    static class Node{
        Node pre;
        Node next;
        int val;

        public Node(int val) {
            pre = null;
            next = null;
            this.val = val;
        }
    }
    public static final int PERSON_COUNT = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int total = 0;

            // 헤드 생성 및 첫 노드 연결
            Node head = new Node(-1);
            Node last = new Node(Integer.parseInt(st.nextToken()));
            last.pre = head;
            head.next = last;

            for (int j = 0; j < PERSON_COUNT-1; j++) {
                // 신규 노드 생성
                Node newNode = new Node(Integer.parseInt(st.nextToken()));
                Node cur = last;
                // 넣을 자리 찾음
                int cnt = 0;
                while (cur.val > newNode.val) {
                    cur = cur.pre;
                    cnt++;
                }
                
                // 찾았으면 노드 연결
                linkNodes(newNode, cur);
                total += cnt;

                // last 갱신
                while (last.next != null)
                    last = last.next;
            }
            bw.write(num+" "+total+"\n");
        }
        bw.flush();
    }

    private static void linkNodes(Node newNode, Node cur) {
        newNode.next = cur.next;
        newNode.pre = cur;
        if(cur.next != null)
            cur.next.pre = newNode;
        cur.next = newNode;
    }
}
