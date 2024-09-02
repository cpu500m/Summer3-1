package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G3_1939
 * @date : 2024-09-01
 */
public class G3_1939 {

    private static Map<Integer,Integer>[] maxWeightMap;
    private static int start;
    private static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 입력 처리 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        maxWeightMap = new HashMap[n+1];

        for (int i = 0; i <= n; i++) {
            maxWeightMap[i] = new HashMap<>();
        }

        for (int i = 0; i < m; i++) {
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Integer preWeight;
            // 다리가 아예 없었다면 해당 다리 그대로 사용
            if((preWeight = maxWeightMap[a].get(b)) == null){
                maxWeightMap[a].put(b, weight);
                maxWeightMap[b].put(a, weight);
            } else{ // 기존에 다리가 연결되어 있었다면 어떤게 중량이 더 높은지 따져야함
                int maxWeight = Math.max(weight, preWeight);
                maxWeightMap[a].put(b, maxWeight);
                maxWeightMap[b].put(a, maxWeight);
            }
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        //des 로직
        // parametric search를 통해 1 ~10억 되는값을 구하도록 하자 시간복잡도 계산해봐도
        // O(logN * N )나옴
        int left = 1;
        int right = 1_000_000_001;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(isPossibleWeight(mid))
                left = mid+1;
                else right = mid-1;
        }
        bw.write(String.valueOf(right));
        bw.flush();
    }
    private static boolean isPossibleWeight(int target){
        // 그래프 따라가면서 해당 값으로 갈 수 있나를 따져야함
        Queue<Integer> queue = new LinkedList<>();
        // 방문여부 체크
        boolean[] visited = new boolean[maxWeightMap.length];

        visited[start] = true;
        for(Integer nextCity : maxWeightMap[start].keySet()) {
            if (maxWeightMap[start].get(nextCity) >= target) {
                visited[nextCity] = true;
                queue.add(nextCity);
            }
        }

        while(!queue.isEmpty()){
            int currentCity = queue.poll();
            // 목적지에 도달할 수 있다면 true 리턴
            if(currentCity == end) return true;

            for(Integer nextCity : maxWeightMap[currentCity].keySet()) {
                //방문하지 않았으며 해당 중량을 옮길 수 있는 도로라면 방문체크 후 넣는다
                if (!visited[nextCity] && maxWeightMap[currentCity].get(nextCity) >= target) {
                    visited[nextCity] = true;
                    queue.add(nextCity);
                }
            }
        }
        return false;
    }
}