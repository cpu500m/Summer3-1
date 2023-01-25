// 흠.. 그냥 높은 값을 우선순위 높은거로 처리하고 하자
// 링크드 리스트로 구현햇는데 시간초과 ..;; 시간날림
package Gold;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class G4_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC ; ++tc){
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();

            int k = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < k ; i++){
                StringTokenizer st =new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                switch (command){
                    case 'I':
                        int val = Integer.parseInt(st.nextToken());
                        if(treeMap.containsKey(val))
                            treeMap.put(val,treeMap.get(val)+1);
                        else treeMap.put(val,1);
                        break;
                    case 'D' :
                        int del = Integer.parseInt(st.nextToken());
                        // 높은 값 삭제
                        if(del == 1) {
                            if(!treeMap.isEmpty() && treeMap.lastEntry().getValue() > 1 ){
                                int temp_val =treeMap.lastEntry().getValue()-1;
                                int temp_key = treeMap.lastEntry().getKey();
                                treeMap.pollLastEntry();
                                treeMap.put(temp_key,temp_val);
                            }
                            else treeMap.pollLastEntry();
                        }
                        else {
                            if(!treeMap.isEmpty() && treeMap.firstEntry().getValue() > 1){
                                int temp_val =treeMap.firstEntry().getValue()-1;
                                int temp_key = treeMap.firstEntry().getKey();
                                treeMap.pollFirstEntry();
                                treeMap.put(temp_key,temp_val);
                            }
                            else treeMap.pollFirstEntry();
                        }
                }
            }
            if(treeMap.isEmpty())
                sb.append("EMPTY\n");
            else{
                sb.append(treeMap.lastEntry().getKey()+" "+treeMap.firstEntry().getKey()+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
// 시간초과;;
//static class Node{
//    int data;
//    Node next;
//    Node prev;
//    Node(int data){
//        this.data = data;
//        this.next = null;
//        this.prev = null;
//    }
//}
//    static final int MAX_NODE = 2_000_000;
//    static int node_count = -1;
//    static Node[] node = new Node[MAX_NODE];
//    static Node get_node(int data){
//        node[++node_count] = new Node(data);
//        return node[node_count];
//    }
//    static void init(){
//        head = get_node(Integer.MAX_VALUE);
//        node_count = -1;
//    }
//    static void add_node(int data){
//        Node new_node = get_node(data);
//        Node cur = head;
//        while (cur.next != null){
//            if(cur.next.data < data)
//                break;
//            cur = cur.next;
//        }
//        new_node.next = cur.next;
//        if(new_node.next != null)
//            new_node.next.prev = new_node;
//        new_node.prev = cur;
//        cur.next = new_node;
//    }
//    static void remove_high(){
//        if(head.next == null)
//            return;
//        if(head.next.next != null)
//            head.next.next.prev = head;
//        head.next = head.next.next;
//    }
//    static void remove_low(){
//        Node cur = head;
//        while (cur.next != null){
//            cur = cur.next;
//        }
//        if(cur == head)
//            return;
//        cur.prev.next =null;
//    }
//    static boolean is_empty(){
//        if(head.next == null)
//            return true;
//        return false;
//    }
//    static int get_max(){
//        return head.next.data;
//    }
//    static int get_min(){
//        Node cur = head;
//        while (cur.next != null)
//            cur = cur.next;
//        return cur.data;
//    }
//    static Node head;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//
//        int TC = Integer.parseInt(br.readLine());
//        for(int tc = 1; tc <= TC ; ++tc){
//            init();
//            int k = Integer.parseInt(br.readLine());
//            for(int i = 0 ; i < k ; i++){
//                StringTokenizer st =new StringTokenizer(br.readLine());
//                char command = st.nextToken().charAt(0);
//                switch (command){
//                    case 'I':
//                        add_node(Integer.parseInt(st.nextToken()));
//                        break;
//                    case 'D' :
//                        int del = Integer.parseInt(st.nextToken());
//                        if(del == 1)
//                            remove_high();
//                        else remove_low();
//                }
//            }
//            if(is_empty())
//                sb.append("EMPTY\n");
//            else{
//                sb.append(get_max()+" "+get_min()+"\n");
//            }
//        }
//        bw.write(sb.toString());
//        bw.flush();
//    }
