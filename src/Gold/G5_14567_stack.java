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
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_14567_stack
 * @date : 2024-09-13
 */
public class G5_14567_stack {
    static class Node{
        List<Node> inNodes = new ArrayList<>();
        List<Node> outNodes = new ArrayList<>();
        int term = 1;
        int index;
        Node(int index){
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 0번 index 써도 되는데 그냥 좀더 직관적으로 1번부터 번호 매기고 싶어서 이렇게 했어요
        Node[] nodes = new Node[n + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].outNodes.add(nodes[b]);
            nodes[b].inNodes.add(nodes[a]);
        }

        // 결과를 기록하기 위한 스택
        Stack<Node> resultStack = new Stack<>();

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < nodes.length; i++) {

            if(visited[i]) continue;

            // DFS를 위한 스택
            Stack<Node> dfsStack = new Stack<>();

            visited[i] = true;
            dfsStack.push(nodes[i]);

            while (!dfsStack.isEmpty()) {
                // 현재 노드를 가져옵니다 (스택에서 꺼내지는 않습니다.)
                Node curNode = dfsStack.peek();

                // 재귀를 이용하여 구현하였다면 if 문으로 감싼건 빼고 작성.
                if(curNode.outNodes.isEmpty()) {
                    dfsStack.pop();
                    resultStack.push(curNode);
                    if(curNode.inNodes.isEmpty()) {
                        visited[curNode.term] = true;
                    }
                }

                List<Node> curOutList = new ArrayList<>(curNode.outNodes);
                for (Node outNode : curOutList) {
                    // 이전에 outNode의 학기 수가 갱신됐을 수 있으므로 비교 후 최댓값을 넣어줘야 함.
                    outNode.term = Math.max(curNode.term+1, outNode.term);
                    // 재귀를 이용하여 구현하였다면 outNode에서 안뺴줘도 됨. 아래 코드 불필요
                    curNode.outNodes.remove(outNode);
                    dfsStack.push(outNode);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nodes.length; i++) {
            sb.append(nodes[i].term).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
