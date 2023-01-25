// 음.. 이게 내가 알던 외판원 순회는 시작 도시가 정해져있었는데
// 뭐 어차피 생각해보니깐 1- 2- 3- 4 - 5든
// 5- 1 - 2 -3  -4 든 똑같으니깐..
// 걍 하면될듯
// 계속 틀려서 왜틀렸는지 2시간을 고민했는데
// 조건식을 visit & (1<<i) == 1 이라고했음 ㅋㅋ 아 ㅋㅋ

package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1_2098 {
    static int[][] cache;
    static int[][] W;
    static int N;
    static final int MAX = 800_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*      입력  처리      */
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        //index
        int i,j;
        for(i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < N; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        /*      로직      */
        cache = new int[N][1<<N];
        for( i = 0 ; i < N; i++)
            Arrays.fill(cache[i] , -1);
        // 0번에서 출발하여 현재 마스킹이 000..01 이렇게 돼있는상태
        int result = dp(0, 1);
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static int dp(int cur, int visit){
        // 갱신되지 않은 곳이라면 갱신해줘야지
        if(cache[cur][visit] != -1)
            return cache[cur][visit];
        // 모든 도시 방문한 경우
        if(visit == (1<<N)-1) {
            // 처음 출발한 도시로의 경로가 없다면? 그럼 MAX
            if(W[cur][0] != 0) {
                return (cache[cur][visit] = W[cur][0]);
            }
            return (cache[cur][visit] = MAX);
        }
        // 일단 MAXIMUM 값 넣어두고
        cache[cur][visit] = MAX;
        // index
        int i;
        int next;
        // 0번 도시는 출발도시니깐 1~ N-1을 경유하는데
        for(i = 1; i < N ; i++){
            // 경유하려는 도시가 포함 돼있거나 (이미 방문 했거나) 현재 도시에서 경유하려는 도시로 연결 간선이 없다면 넘긴다.
            if((visit & (1<<i)) != 0 || W[cur][i] == 0) continue;
            // 경유지를 비트마스킹한다
            next = (visit | (1<<i));
            // [현재 지점][방문한 도시들] 값을 갱신해준다
            cache[cur][visit] = Math.min(cache[cur][visit] , (dp(i,next) + W[cur][i]) );
        }
        return cache[cur][visit];
    }
}
