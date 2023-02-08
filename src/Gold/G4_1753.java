package Gold;

import java.io.*;
import java.util.*;

public class G4_1753 {
    static class City{
        int distance , city_idx;
        City(int distance, int city_idx){
            this.distance = distance;
            this.city_idx = city_idx;
        }
    }
    static class Node{
        int dest , distance;
        Node(int dest, int distance){
            this.dest =dest;
            this.distance = distance;
        }
    }
    final static int MAX = 1_000_000_001;
    static ArrayList<Node>[] arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb =new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        arrayList = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i++)
            arrayList[i] = new ArrayList<>();

        int[] distance = new int[N+1];
        Arrays.fill(distance,MAX);
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arrayList[s].add(new Node(e,cost));
        }

        // 다익스트라
        dijkstra(start, distance, N );
        for(int i = 1 ; i <= N ; i++) {
            if(distance[i] == MAX)
                sb.append("INF\n");
            else
                sb.append(distance[i]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void dijkstra(int start,int[] distance,  int N){
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
            for(Node n : arrayList[cur_city]){
                if(visit[n.dest]) continue;
                if(distance[n.dest] > cur_distance + n.distance) {
                    distance[n.dest] = cur_distance+n.distance;
                    p_queue.add(new City(distance[n.dest], n.dest));
                }
            }
        }
    }
}
