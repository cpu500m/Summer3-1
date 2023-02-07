package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_1916 {
    final static int MAX = 1_000_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        // 걍 매번 -1 -1 하기 귀찮아서 한행 한열 더뒀음 어차피 넉넉하니깐
        int[][] graph = new int[N+1][N+1];
        int[] distance = new int[N+1];
        Arrays.fill(distance,MAX);
        for(int i = 0 ; i < N+1 ; i++)
            Arrays.fill(graph[i] ,MAX);
        StringTokenizer st;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(graph[s][e] > cost)
                graph[s][e] = cost;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        // 다익스트라
        dijkstra(start, distance, graph, N , destination);
        bw.write(String.valueOf(distance[destination]));
        bw.flush();
    }
    static void dijkstra(int start,int[] distance, int[][] graph, int N , int destination){
        // 일단 시작 부분의 값을 갱신해야됨 visit도 만들고
        boolean[] visit = new boolean[N+1];
        visit[start] = true;
        distance[start] = 0;

        // 거리 갱신하고
        for(int i = 1 ; i < distance.length ; i++)
            distance[i] = Math.min(graph[start][i], distance[i]);

        // 최단 길이를  찾아야 됨
        // 시작점 제외 N-1번 내부에서 N개의 노드에 대한 길이정보를 갱신하니깐 O(N^2)
        for(int i = 0 ; i < N-1 ; i++){
            // 다음 방문할 도시
            int next_city = find_min_idx(distance,visit);
            visit[next_city] = true;
            if(next_city == destination) break;
            for(int j = 1 ; j <= N ; j++){
                // 방문 했던 도시라면 굳이 안해도 된다 어차피 0이상 이니깐 가중치가
                if(visit[j]) continue;
                // 방문한 도시부터 인접 노드들의 거리 갱신
                if(distance[j] > distance[next_city] + graph[next_city][j]) {
                    distance[j] = distance[next_city] + graph[next_city][j];
                }
            }
        }
    }
    static int find_min_idx(int[] distance , boolean[] visit){
        int min_distance = MAX;
        int min_city = -1;
        for(int i = 1 ; i < distance.length ; i++){
            // 방문한 도시라면 건너뛴다
            if(visit[i]) continue;
            if(min_distance > distance[i]){
                min_distance = distance[i];
                min_city = i;
            }
        }
        return min_city;
    }
}
