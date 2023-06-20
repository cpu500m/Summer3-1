// 알고리즘 재활 ... 얼마만이지;;
// 우선 문제를 보고 생각해 본바로는 이렇다. 목표 시간복잡도는 O(N*log N) 이어야 한다.
// 그러려면 우선적으로 생각나는것은 tree인데.. ( N번 루프를 돌며 최악의 경우 트리의 높이만큼(skewed 아닌 tree) )
// 이는 상당히 어려울 것이라고 생각이 됨.
// 그러면이제 graph밖에 없는데..
// 방향성 그래프로 나타내고 진입차수를 기록해 놨다가
// 1 . 진입차수 0인애들 priority_queue에다가 모두 넣어놓음 ( N 번 돌면서) -- 이때 우선순위 큐는 작은 값 우선.
// 2 . 우선순위 큐에서 하나 빼고 진출 화살표로 연결된 애들 진입차수 -= 1 해주고 만약 0이라면 우선순위 큐에 넣는다
// + StringBuilder 에도 기록 ( 출력 목적 )
// 이 두 과정을 priority queue가 빌 때 까지 반복해 주면 답이 나올거같다..
// 시간복잡도를 따져보자니 음 최악의 경우 .. 엮인 정보가 최대 100,000 이므로 아무리 최악이어도 N*log N 을 넘을 수 없다는 계산.
// 시간복잡도 면에서 ㅇㅋ.  공간 복잡도는 32,000개의 class 정보. 우선순위큐 , 등등 해도 128MB가 넘지는 않겠다.
package Gold;

import java.io.*;
import java.util.*;

public class G2_1766 {

    static class Node{
        int in_degree;
        List<Integer> arrayList;
        Node(){
            in_degree = 0;
            arrayList = new ArrayList<>();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 우선순위 큐 생성 및 출력을 위한 스트링빌더
        Queue<Integer> p_queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        // 노드 생성
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N ; i++) {
            nodes[i] = new Node();
        }

        // 진입차수 설정 및 리스트에 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int out_node = Integer.parseInt(st.nextToken());
            int in_node = Integer.parseInt(st.nextToken());
            nodes[in_node].in_degree++;
            nodes[out_node].arrayList.add(in_node);
        }

        // 1 . N번 돌면서 진입차수가 0인 노드를 우선순위 큐에 추가한다.
        for (int i = 1; i <= N; i++) {
            if(nodes[i].in_degree == 0)
                p_queue.add(i);
        }

        // 2 . 우선순위 큐가 빌때까지 위에 로직을 반복한다.
        while (!p_queue.isEmpty()) {
            int cur_node = p_queue.poll();
            sb.append(cur_node+" ");
            for(int n : nodes[cur_node].arrayList){
                nodes[n].in_degree--;
                if(nodes[n].in_degree == 0)
                    p_queue.add(n);
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
