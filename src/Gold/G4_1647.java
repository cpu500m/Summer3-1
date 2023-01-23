package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G4_1647 {
    static int[] connect;
    static class Edge{
        int t1 ,t2, weight;
        Edge(int t1, int t2, int weight){
            this.t1 = t1;
            this.t2 = t2;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*     입력 처리        */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V= Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        connect = new int[V+1];
        Edge[] edge = new Edge[E];
        // index
        int i;
        int cnt = 0;
        for(i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int A= Integer.parseInt(st.nextToken());
            int B=  Integer.parseInt(st.nextToken());
            int weight=  Integer.parseInt(st.nextToken());
            edge[i] = new Edge(A,B,weight);
        }
        /*  로직  */
        // weight 기준 오름차순 정렬
        Arrays.sort(edge, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight- o2.weight;
            }
        });
        // 모든 부모노드를 자기 자신으로
        for(i= 0 ; i <= V ; i++)
            connect[i] = i;

        i = 0;
        // 결과
        int cost = 0;
        // 결국 Vertex -2 개의 간선이 존재할거임
        while (cnt != V-2){
            Edge cur = edge[i++];
            int t1 = cur.t1;
            int t2 = cur.t2;
            // t1에다가 t2을 합치는 느낌으로 가자
            int t1_root = find_front(t1);
            int t2_root = find_front(t2);

            if(t1_root != t2_root){
                connect[t2_root] = t1_root;
                cnt++;
                cost += cur.weight;
            }
        }
        bw.write(String.valueOf(cost));
        bw.flush();
    }
    static int find_front(int vertex) {
        int cur = vertex;
        if(connect[vertex] == vertex) return vertex;
        return connect[vertex] = find_front(connect[vertex]);
    }
}
