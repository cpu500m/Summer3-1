// 점화식을 구해보면
// dp[n][k] = Min( dp[n-1][k] , dp[n][k-coin[n]] + 1)
// 로 정의 내릴 수 있겠음.

package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // dp를 위한 배열
        int[] dp = new int[k + 1];
        int[] coins = new int[n];
        int cur_coin;
        // index
        int i, j;
        for (i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        /*      로직      */
        // dp 배열 내부를 나올 수 없는 값 초기화하되 ,시작은 0으로
        Arrays.fill(dp,10001);
        dp[0] = 0;
        // 우선 , 사용 가능한 동전을 오름차순으로 정렬한다.
        Arrays.sort(coins);

        // 위에서 도출한 점화식을 이용하여 작성한다.
        for(i = 0 ; i < n ; i++){
            cur_coin = coins[i];
            for(j =cur_coin; j< k +1; j++){
                dp[j] = Math.min(dp[j], dp[j-cur_coin]+1);
            }
        }
        if(dp[k] == 10001)
            dp[k] = -1;
        bw.write(String.valueOf(dp[k]));
        bw.flush();
    }
}
