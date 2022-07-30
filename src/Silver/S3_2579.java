// i번째 계단을 포함하는 최적의 식은
// i-2번째를 포함하고 , i번째를 밟거나 혹은
// i-2를 안밟고 i-1, i번째를 밟는 경우. ( 이때 i-3번째는 밟아야함)
package Silver;

import java.io.*;

public class S3_2579 {
    private static final int INCLUDE = 1;
    private static final int NOT_INCLUDE = 0;
    private static int[] stairs;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        dp  = new int[N+1][2];
        for(int i =1 ; i <= N ; i++)
            stairs[i] = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(getMaxValue(N)));
        bw.flush();
    }
    private static int getMaxValue(int N){
        dp[1][INCLUDE] = stairs[1];
        if( N== 1)
            return dp[1][INCLUDE];
        dp[2][INCLUDE] = stairs[1] + stairs[2]; dp[2][NOT_INCLUDE] = stairs[1];
        for(int i = 3 ; i <=N ; i++){
           dp[i][NOT_INCLUDE] = dp[i-1][INCLUDE];
           dp[i][INCLUDE] = Math.max(dp[i-2][INCLUDE]+stairs[i],dp[i-2][NOT_INCLUDE]+stairs[i-1]+stairs[i]);
        }
        return dp[N][INCLUDE];
    }
}
