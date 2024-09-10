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
 * @fileName : G4_13424
 * @date : 2024-09-10
 */
public class G4_13424 {

    static class Info{
        int pos;
        int distance;

        Info(int pos, int distance){
            this.pos = pos;
            this.distance = distance;
        }
    }

    private static final int MAX = 100_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 방 개수
            int n = Integer.parseInt(st.nextToken());
            // 통로 개수
            int m = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[n+1][n+1];
            for (int i = 0; i < n + 1; i++) {
                Arrays.fill(matrix[i],MAX);
            }

            // 자기 자신까지 거리 0
            for (int i = 1; i < n + 1; i++) {
                matrix[i][i] = 0;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                matrix[a][b] = c;
                matrix[b][a] = c;
            }
            int k = Integer.parseInt(br.readLine());

            // 다익스트라 돌리기
            st = new StringTokenizer(br.readLine());
            int[] sum = new int[n+1];
            for (int i = 0; i < k; i++) {
                int[] arr = dijkstra(matrix ,Integer.parseInt(st.nextToken()));
                for (int j = 0; j < sum.length; j++) {
                    sum[j] += arr[j];
                }
            }

            // 만날 장소 정하기
            int minValue = MAX;
            int index = -1;
            for (int i = 1; i < sum.length; i++) {
                if(minValue > sum[i]){
                    minValue = sum[i];
                    index = i;
                }
            }
            sb.append(index).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private static int[] dijkstra(int[][] matrix, int start) {
        PriorityQueue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i.distance));

        int[] dist = new int[matrix.length];
        Arrays.fill(dist,Integer.MAX_VALUE);

        queue.add(new Info(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Info cur = queue.poll();
            for (int i = 1; i < matrix.length; i++) {
                int temp = matrix[cur.pos][i];
                if(cur.distance + matrix[cur.pos][i] < dist[i]){
                    dist[i] = cur.distance + matrix[cur.pos][i];
                    queue.add(new Info(i, dist[i]));
                }
            }
        }
        return dist;
    }
}
