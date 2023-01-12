// 흠....
// 일단 인접한 네방향에 대해서 항상 검사를하는데
// 특정 방향에 대해서 검사하는것의 식을써보면
// dp[a][b] += dp[a-1][b] ( if map[a][b] < map[a-1][b] )
// 와 같이 쓰면 되지않을까?
// 함 해봄
// 아 근데이게 주 문제는 그게아니라
// 이제 어떻게하면 시간 복잡도를 크게 증가시키지 않고 한번지나간 길에다 다시 기록을 해줄거냐인데..

// 이건 BFS로는 안되겠는데? DFS해야겠다
// 아 근데 아무리 생각해도 초기 출발점부터 출발해서 저장해놓으면서 가는건 답이없어서
// 너무 답답해서 찾아봤음.... 근데이게 재귀호출을 이용하는 방식을 내가 생각을 못했다;;
// 하 DP 공부좀 더 많이해야겠다

package Gold;

import java.io.*;
import java.util.*;

public class G3_1520 {

    static int M,N;
    static int[][] map;
    static int[][] dp;
    static int[] x_dir = {1,-1,0,0};
    static int[] y_dir = {-0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index
        int i,j;

        /*      입력 처리       */
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
       map = new int[M+2][N+2];
        dp = new int[M+2][N+2];

        // 외곽에는 가지못하게 처리해놓음, dp도 -1로 초기화
        for(i = 0; i < M+2; i++) {
            Arrays.fill(map[i], -1);
            Arrays.fill(dp[i],-1);
        }

        for(i = 1 ; i <= M ; i++){
            st = new StringTokenizer(br.readLine());
            for(j = 1; j <= N ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        /* 로직 */
        bw.write(String.valueOf(dfs(1,1)));
        bw.flush();
    }
    static int dfs(int x, int y){
        // index
        int i ;
        int cur_x , cur_y;

        if(x == M && y == N)
            return 1;
        if(dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = 0;

        /*      로직      */
        for(i = 0 ; i < 4 ; i++){
            cur_x = x + x_dir[i];
            cur_y = y + y_dir[i];
            if(map[cur_x][cur_y] != -1 && map[x][y] > map[cur_x][cur_y])
                dp[x][y] += dfs(cur_x,cur_y);
        }
        return dp[x][y];
    }
}
