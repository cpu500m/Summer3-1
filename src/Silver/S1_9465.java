// 만약 행이 여러 행이였다면 조금더 생각해봤을거같음.
// 하지만 행이 2개라는 점에서,
// 스티커를 왼쪽에서 오른쪽으로 대각선으로 떼가며 최댓값을 저장하는 식으로 하면됨.
// 그러니깐 점화식을 구하자면
// dp[K][위] = max( dp[k-1][아래] + dp[k][위] , dp[k-1][위] )
// dp[k][아래] = max ( dp[k-1][아래] , dp[k-1][위] + dp[k][아래] )
// 그리고 최종적으로 optimal_value = max (dp[n][위] , dp[n][아래] ) 해주면 될 것임.
package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        /*       입력처리       */
        int tc_count = Integer.parseInt(br.readLine());
        int n;
        int[][] sticker;
        int[][] dp;
        // index
        int i, j, k;
        for( i = 0 ; i < tc_count ; i++){
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n+2];

            // 우선 , 0을 채워넣어놓는다. ( 범위밖공간을 0으로 초기화함이 목적임)
            for(j = 0; j< 2; j++)
            Arrays.fill(sticker[j],0);

            for( j = 0 ; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (k = 1; k <= n; k++)
                    sticker[j][k] = Integer.parseInt(st.nextToken());
            }

            /*      로직      */
            for(j = 1; j <= n; j++){

                sticker[0][j] = Math.max(sticker[0][j-1], sticker[0][j]+sticker[1][j-1]);
                sticker[1][j] = Math.max(sticker[1][j] + sticker[0][j-1] , sticker[1][j-1]);
            }
            sb.append(Math.max(sticker[0][n], sticker[1][n])+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
