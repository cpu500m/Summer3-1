package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G3_9470
 * @date : 2024-09-22
 */
public class G3_9470 {

    static class Node{
        int[] strahlerCount;
        int strahler;
        List<Node> inNodeList = new ArrayList<>();
        List<Node> outNodeList = new ArrayList<>();
        Node(int m){
            strahlerCount = new int[m];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            // create nodes
            Node[] nodes= new Node[m+1];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node(m+1);
            }

            // inNode 및 outNode 초기화
            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[a].outNodeList.add(nodes[b]);
                nodes[b].inNodeList.add(nodes[a]);
            }

            // topological sort
            Queue<Node> queue = new LinkedList<>();

            for (int i = 1; i < nodes.length; i++) {
                if(nodes[i].inNodeList.isEmpty()) {
                    nodes[i].strahlerCount[0] = 2;
                    queue.add(nodes[i]);
                }
            }

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                for (int i = m; i >= 0; i--) {
                    if(cur.strahlerCount[i] > 0) {
                        cur.strahler = i;
                        if(cur.strahlerCount[i] > 1) {
                            cur.strahler = i + 1;
                        }
                        break;
                    }
                }

                for (Node next : cur.outNodeList) {
                    next.strahlerCount[cur.strahler]++;
                        next.inNodeList.remove(cur);
                    if(next.inNodeList.isEmpty()) {
                        queue.add(next);
                    }
                }
            }

            sb.append(k).append(" ").append(nodes[m].strahler).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}