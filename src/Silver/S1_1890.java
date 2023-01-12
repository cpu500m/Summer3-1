package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1890 {
    static int[] x_dir = {1,0};
    static int[] y_dir = {0,1};
    static int[][] board;
    static long[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        /*      입력 처리       */
        N = Integer.parseInt(br.readLine());
        board = new int[N + 2][N + 2];
        dp = new long[N+2][N+2];
        // index
        int i,j;

        for(i = 1 ; i <= N ;i++){
            st = new StringTokenizer(br.readLine());
            for(j=1 ; j<= N ; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        /*      로직      */
        // 우선 , DP내부를 -1로 초기화한다.
        for(i= 0 ; i < N+2; i++)
            Arrays.fill(dp[i],-1);

        bw.write(String.valueOf(dfs(1,1)));
        bw.flush();
    }
    static long dfs(int x, int y){
        // index
        int i;
        int cur_x , cur_y;
        if(x == N && y == N)
            return 1;
        if(dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = 0;

        if(board[x][y] == 0)
            return dp[x][y];

        int move = board[x][y];

        for(i = 0 ; i <2 ; i++){
            cur_x = x + x_dir[i]*move;
            if(cur_x > N)
                continue;
            cur_y = y+ y_dir[i]*move;
            if(cur_y > N)
                continue;
            dp[x][y] += dfs(cur_x,cur_y);
        }

        return dp[x][y];
    }
}