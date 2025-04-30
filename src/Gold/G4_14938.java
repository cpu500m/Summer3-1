package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G4_14938
 * @date : 25. 4. 30.
 */
public class G4_14938 {

    private static class Node{
        int dist;
        int idx;

        Node(int dist, int idx){
            this.dist = dist;
            this.idx = idx;
        }
    }

    private static final int INF = 999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* 입력 처리 */
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n];
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], INF);
            matrix[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken())-1;
            int n2 = Integer.parseInt(st.nextToken())-1;
            int dist = Integer.parseInt(st.nextToken());

            matrix[n1][n2] = dist;
            matrix[n2][n1] = dist;
        }

        /* 로직 */
        // 각 노드에서 다익스트라 돌려야 할듯
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2.dist));
        int max = 0;
        for(int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, INF);

            dist[i] = 0;
            pq.add(new Node(0, i));

            // 최단거리 배열을 구한다
            while(!pq.isEmpty()) {
                Node curNode = pq.poll();
                int curDist = curNode.dist;

                for (int j = 0; j < n; j++) {
                    if(curDist + matrix[curNode.idx][j] < dist[j]) {
                        dist[j] = curDist + matrix[curNode.idx][j];
                        pq.add(new Node(curDist + matrix[curNode.idx][j],j));
                    }
                }
            }

            int sum = 0;

            for(int j = 0 ; j < n ; j++) {
                if(dist[j] <= m){
                    sum += items[j];
                }
            }
            if(sum > max){
                max = sum;
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}
