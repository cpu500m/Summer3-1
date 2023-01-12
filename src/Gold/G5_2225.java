// 흠.. 일단 N이라는 숫자를만들기 전에
// long DP[K+1][N+1]라는 배열을 만들어서 내부에 경우의 수를 저장하는거임.
// N은 이제 지금까지 숫자 몇개를 썼는가.
// K는 조합해서 나온 수.
// 그러면 점화식을 한번 설계해봐야하는데 잠시 생각을..
// 일단 1개만 선택하는 경우는 다 1일테고
// 2개를 선택해서 만드는 경우는
// 예를들어 k = 2 이고 현재 7이라는 숫자를 만들고 있다고 치자. 그러면
// dp[2][7] = dp[1][0]+dp[1][1] + dp[1][2] + ... + dp[1][7] 임.
// 그니깐 dp[k][a] = 1 ( if k == 1)
//       dp[k][a] = dp[k-1][0] + dp[k-1][1] + ... dp[k-1][a] ( k > 1 )
// 와 같이 정리해 볼 수 있을거같네.

// 근데 이게 위처럼 그대로 루프를 계속돌려서 구현을하면은 k> 1인 매 행마다 a!번 루프를 돌아야하니깐
// 이거는 무조건 시간초과가 날거란말이지?
// 그래서 누적 합 배열을 하나 더 만들어서 해결해볼 예정임.


package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*         입력 처리        */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] sum = new long[N+1];
        long[][] dp = new long[K+1][N+1];

        // index
        int i ,j;

        /*      로직      */
        // 우선 경우의 수들을 0으로 초기화 시킨다.
        for(i = 0 ; i <K+1 ; i++)
            Arrays.fill(dp[i],1);

        // 일단 k = 1 인 상태에서의 누적합을 계산해놓음.
        for( i = 0 ; i < N+1; i++)
            sum[i] = i+1;

        // 위의 점화식대로 해결.
        for( i = 2 ; i < K+1 ; i++){
            for(j = 0 ; j < N+1 ; j++){
                dp[i][j] = sum[j];
            }
            // sum 배열 값을 바꿔준다.
            sum[0] = dp[i][0];
            for(j = 1 ; j < N+1 ; j++)
                sum[j] = (sum[j-1] + dp[i][j]) % 1_000_000_000;
        }
        bw.write(String.valueOf(dp[K][N]));
        bw.flush();
    }
}
