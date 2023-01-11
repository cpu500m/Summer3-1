// 점화식을 도출한 결과 아래와 같았음.
// dp[n][k] = dp[n-1][k] + dp[n][k - coin[n]];
// 다만 , 메모리 제한이 4MB라는 점에서,
// (n+1)*(k+1)개의 int 배열을 생성할경우 4MB를 초과하기 때문에
// 이전 기록에 덮어쓰는 방식으로 1차원 배열을 사용.

package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // dp를 위한 배열
        int[] dp = new int[k+1];
        int[] coins = new int[n];
        int cur_coin;
        // index
        int i, j;
        for(i = 0 ; i < n ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        /*      로직      */
        // 오름차순으로 정렬후 도출한 점화식을 이용한다.
        Arrays.sort(coins);
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(i = 0 ; i < n ; i++){
            cur_coin = coins[i];
            for(j = cur_coin ; j < k+1 ; j++)
                dp[j] = dp[j] + dp[j-cur_coin];
        }
        bw.write(String.valueOf(dp[k]));
        bw.flush();
    }
}
