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
 * @fileName : G5_14567
 * @date : 2024-09-13
 */
public class G5_14567_queue {
    static class Node{
        List<Node> inNodes = new ArrayList<>();
        List<Node> outNodes = new ArrayList<>();
        int term = 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 0번 index 써도 되는데 그냥 좀더 직관적으로 1번부터 번호 매기고 싶어서 이렇게 했어요
        Node[] nodes = new Node[n+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].outNodes.add(nodes[b]);
            nodes[b].inNodes.add(nodes[a]);
        }

        Queue<Node> queue = new LinkedList<>();

        for (int i = 1; i < nodes.length; i++) {
            if(nodes[i].inNodes.isEmpty())
                queue.add(nodes[i]);
        }

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            // 진출간선으로 연결된 정점들에 대해 루프.
            for (Node outNode : curNode.outNodes) {
                // 해당 정점의 진입 정점 리스트에서 현재 정점을 제거한다.
                outNode.inNodes.remove(curNode);
                // 만약, 해당 정점의 진입 정점 리스트가 비었다면, 큐에 삽입한다.
                if(outNode.inNodes.isEmpty()){
                    // 해당 과목을 몇 학기에 이수할수 있는지 정보를 갱신한다.
                    outNode.term = curNode.term+1;
                    queue.add(outNode);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nodes.length; i++) {
            sb.append(nodes[i].term+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}