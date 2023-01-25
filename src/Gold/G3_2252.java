package Gold;

import java.io.*;
import java.util.*;

public class G3_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=  new StringBuilder();

        /*  입력  처리  */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 진입 차수 0으로 초기화
        int[] in_degree = new int[N+1];
        Arrays.fill(in_degree,0);
        // 진출해서 만나는 노드들을 기록해주기위해.. 그냥 배열 쓰면 메모리초과라 얘씀
        ArrayList<Integer>[] out = new ArrayList[N+1];
        // index
        int i;
        for(i = 0 ; i < N+1 ; i++)
            out[i] = new ArrayList<>();
        int first , second;
        for(i = 0 ; i < M ; i++){
            st= new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
            in_degree[second]++;
            out[first].add(second);
        }

        Queue<Integer> queue = new LinkedList<>();
        int cur;
        /*      로직      */
        // 방문 여부를 표시
        boolean[] visit = new boolean[N+1];
        int temp;
        // 진입 차수가 0 인애를 찾는다.
        for(i = 1 ; i <= N ; i++) {
            if(in_degree[i] == 0){
                queue.add(i);
                visit[i] = true;
            }
        }

        while (!queue.isEmpty()){
            cur = queue.poll();
            sb.append(cur+" ");
            // 인접한 애들의 진입 차수 감소
            for(int j = 0 ; j < out[cur].size() ; j++){
                temp = out[cur].get(j);
                in_degree[temp]--;
                if(in_degree[temp] == 0 && visit[temp] == false)
                    queue.add(temp);
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
