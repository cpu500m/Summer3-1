package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S1_1932 {
    private static int[][] triangle;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int height = Integer.parseInt(br.readLine());
        triangle = new int[height+1][height+2];
        dp = new int[height+1][height+2];
        for(int i = 1 ; i <= height ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(String.valueOf(findMaxValue(height)));
        bw.flush();
    }
    private static int findMaxValue(int height){
        int max_value = Integer.MIN_VALUE;
        for(int i = 1 ; i <= height; i++){
            for(int j = 1; j <= i ; j++){
                dp[i][j] = Math.max(dp[i-1][j]+triangle[i][j] , dp[i-1][j-1]+triangle[i][j]);
            }
        }
        for(int i =1 ; i <= height ; i++)
            if(max_value < dp[height][i])
                max_value = dp[height][i];
        return max_value;
    }
}
