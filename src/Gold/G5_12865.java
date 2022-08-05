// 2학년때 배웠던 knapsack
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G5_12865 {
    private static int N,K;
    private static int[][] knapsack;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        knapsack = new int[N][2];
        dp = new int[N+1][K+1];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            knapsack[i][0] = Integer.parseInt(st.nextToken());
            knapsack[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(knapsack, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        bw.write(String.valueOf(getMaxValue()));
        bw.flush();
    }
    private static int getMaxValue(){
        int max_value = -1;
        for(int i =1 ; i <= N ; i++){
            for(int j = 0; j <= K ; j++){
                if (knapsack[i-1][0]+j <= K){
                    dp[i][j+ knapsack[i-1][0]] = dp[i-1][j] + knapsack[i-1][1];
                }
                if( dp[i][j] < dp[i-1][j] )
                    dp[i][j] = dp[i-1][j];
            }
        }
        for(int i = 0 ; i <= K ; i++){
            if( max_value<dp[N][i])
                max_value = dp[N][i];
        }
        return max_value;
    }
}
