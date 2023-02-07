// 이번에는 우선순위 큐로 한번 맛깔나게
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_1916_2 {
    static class City{
        int distance , city_idx;
        City(int distance, int city_idx){
            this.distance = distance;
            this.city_idx = city_idx;
        }
    }
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
        PriorityQueue<City> p_queue = new PriorityQueue<>(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.distance -o2.distance;
            }
        });
        boolean[] visit = new boolean[N+1];
        distance[start] = 0;
        p_queue.add(new City(0, start));
        while (!p_queue.isEmpty()){
            City cur = p_queue.poll();
            int cur_city = cur.city_idx;
            int cur_distance = cur.distance;
            visit[cur_city] = true;
            for(int i= 1 ; i <= N ;i++){
                if(visit[i]) continue;
                if(distance[i] > cur_distance + graph[cur_city][i]) {
                    distance[i] = cur_distance+graph[cur_city][i];
                    p_queue.add(new City(distance[i], i));
                }
            }
        }
    }
}
