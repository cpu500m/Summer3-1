// S3_2579번과 매우 유사해서 코드 거의 그대로 씀
package Silver;

import java.io.*;

public class S1_2156 {
    private static final int INCLUDE = 1;
    private static final int NOT_INCLUDE = 0;
    private static int[] bottles;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bottles = new int[N+1];
        dp  = new int[N+1][2];
        for(int i =1 ; i <= N ; i++)
            bottles[i] = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(getMaxValue(N)));
        bw.flush();
    }
    private static int getMaxValue(int N){
        dp[1][INCLUDE] = bottles[1];
        if( N== 1)
            return dp[1][INCLUDE];
        dp[2][INCLUDE] = bottles[1] + bottles[2]; dp[2][NOT_INCLUDE] = bottles[1];
        for(int i = 3 ; i <=N ; i++){
            dp[i][NOT_INCLUDE] = Math.max(dp[i-1][INCLUDE],dp[i-1][NOT_INCLUDE]);
            dp[i][INCLUDE] = Math.max(dp[i-2][INCLUDE]+bottles[i],dp[i-2][NOT_INCLUDE]+bottles[i-1]+bottles[i]);
        }
        return Math.max(dp[N][INCLUDE],dp[N][NOT_INCLUDE]);
    }
}
