package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_5972
 * @date : 2024-09-02
 */
public class G5_5972 {

    static class Info {

        int distance;
        int pos;

        Info(int distance, int pos) {
            this.distance = distance;
            this.pos = pos;
        }
    }

    public static BufferedReader br;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 입력 처리 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1부터 n까지의 cow count 최적값
        int[] dist = new int[n + 1];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        // 인접 리스트 초기화
        List<Info>[] adjacencyList = initAdjacencyList(n, m);

        // 오름차순 정렬
        dijkstra(adjacencyList, dist);

        bw.write(String.valueOf(dist[n]));
        bw.flush();
    }

    private static List<Info>[] initAdjacencyList(int n, int m) throws IOException {
        StringTokenizer st;
        List<Info>[] adjacencyList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjacencyList[a].add(new Info(c, b));
            adjacencyList[b].add(new Info(c, a));
        }
        return adjacencyList;
    }

    private static void dijkstra(List<Info>[] adjacencyList, int[] dist) {
        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(info -> info.distance));

        queue.add(new Info(0, 1));

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            int curPos = info.pos;
            int curDistance = info.distance;

            for (int i = 0; i < adjacencyList[curPos].size(); i++) {
                Info nextInfo = adjacencyList[curPos].get(i);
                int nextDistance = curDistance + nextInfo.distance;
                if(nextDistance < dist[nextInfo.pos]) {
                    dist[nextInfo.pos] = nextDistance;
                    queue.add(new Info(nextDistance, nextInfo.pos));
                }
            }
        }
    }
}
