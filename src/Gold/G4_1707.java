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
 * @fileName : G4_1707
 * @date : 2025-04-14
 */
public class G4_1707 {

    private static final char NOT_VISITED = '0';
    private static final char SET1 = '1';
    private static final char SET2 = '2';

    static class Node{
        List<Integer> list = new ArrayList<>();
        char set = NOT_VISITED;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 1. 노드 배열 생성
            Node[] nodes = new Node[V+1];

            for(int i = 1; i < nodes.length; i++) {
                nodes[i] = new Node();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                nodes[s].list.add(e);
                nodes[e].list.add(s);
            }

            Queue<Node> queue = new LinkedList<>();

            boolean isBipartiteGraph = true;

            for (int i = 1; i < nodes.length; i++) {
                if(isBipartiteGraph && nodes[i].set == NOT_VISITED) {
                    queue.add(nodes[i]);
                    nodes[i].set = SET1;
                }
                while(!queue.isEmpty()) {
                    Node cur = queue.poll();
                    int curSet = cur.set;

                    for (Integer nextNodeIndex : cur.list) {
                        if(nodes[nextNodeIndex].set != NOT_VISITED) {
                            if(nodes[nextNodeIndex].set == curSet) {
                                isBipartiteGraph = false;
                                break;
                            }
                            continue;
                        }
                        nodes[nextNodeIndex].set = curSet == SET1 ? SET2 : SET1;
                        queue.add(nodes[nextNodeIndex]);
                    }
                }
            }
            bw.write(isBipartiteGraph ? "YES" : "NO");
            bw.write("\n");
        }
        bw.flush();
    }
}
