package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G3_1719
 * @date : 2024-10-13
 */
public class G3_1719 {
    private static class Info{
        int dist;
        int curNode;
        List<Integer> pathList = new ArrayList<>();

        Info(int dist, int curNode){
            this.dist = dist;
            this.curNode = curNode;
        }
    }

    private static class DistInfo{
        int dist;
        List<Integer> pathList;
        DistInfo(int dist, List<Integer> pathList){
            this.dist = dist;
            this.pathList = pathList;
        }
    }

    private static StringBuilder resultBuilder = new StringBuilder();
    private static final int MAX = 123456789;
    private static int N;
    private static int M;
    private static int[][] adjacentMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjacentMatrix = new int[N+1][N+1];

        for (int i = 0; i < adjacentMatrix.length; i++) {
            Arrays.fill(adjacentMatrix[i], MAX);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            adjacentMatrix[node1][node2] = distance;
            adjacentMatrix[node2][node1] = distance;
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }
        bw.write(resultBuilder.toString());
        bw.flush();
    }

    private static void dijkstra(int startIdx) {

        DistInfo[] dist = new DistInfo[N + 1];

        for (int i = 0; i < N + 1; i++) {
            dist[i] = new DistInfo(MAX, new ArrayList<>());
        }
        dist[startIdx].dist = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(info -> info.dist));

        Info startInfo = new Info(0, startIdx);
        pq.add(startInfo);

        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            int curIdx = cur.curNode;
            int curDist = cur.dist;
            for (int i = 1; i <= N; i++) {
                int nextDist = curDist + adjacentMatrix[curIdx][i];
                if (nextDist < dist[i].dist) {
                    Info nextInfo = new Info(nextDist, i);
                    nextInfo.pathList = new ArrayList<>(cur.pathList);
                    nextInfo.pathList.add(i);

                    pq.add(nextInfo);
                    dist[i] = new DistInfo(nextDist, nextInfo.pathList);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i].dist == MAX || dist[i].dist == 0) {
                resultBuilder.append("- ");
            } else {
                resultBuilder.append(dist[i].pathList.get(0)+" ");
            }
        }
        resultBuilder.append("\n");
    }
}
