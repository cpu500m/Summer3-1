// 최악의 경우 N-1번의 루프 각각 에서 BFS를 하니깐 O(N^2)
// 하,,,,,,,,,,,,,, 문제풀때 집중좀하자 ㅎㅎ;
package Gold;

import java.io.*;
import java.util.*;

public class G5_15591 {

    static class Node{
        int nxt;
        int weight;

        Node(int nxt , int weight){
            this.nxt = nxt;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /*  입력  처리  */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 연결 리스트
        ArrayList<Node>[] arrayLists = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arrayLists[n1].add(new Node(n2,w));
            arrayLists[n2].add(new Node(n1 , w));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[N + 1];
            visited[v] = true;
            int cnt = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (Node node : arrayLists[v]) {
                if(!visited[node.nxt] && node.weight >= k){
                    visited[node.nxt] = true;
                    queue.add(node.nxt);
                    cnt++;
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        for (Node n : arrayLists[cur]) {
                            if(!visited[n.nxt] && n.weight >= k){
                                visited[n.nxt] = true;
                                queue.add(n.nxt);
                                cnt++;
                            }
                        }
                    }
                }
            }
            sb.append(String.valueOf(cnt) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
