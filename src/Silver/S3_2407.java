// nCm은 n-1 C m-1 + n-1 C m 이므로
// 뭐 divide and conquer 또는 DP로 해결할 수 있지만
// 조합은 하위집합이 상위집합과 밀접한 관계를 맺고
// 하위집합이 상위집합 계산할때 2번이상 쓰일 수 있는 문제기 때문에 DP를 사용.

package Silver;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_2407 {
    static BigInteger[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index
        int i;

        /*      입력 처리       */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new BigInteger[n+1][m+1];

        // dp 내부 -1 초기화
        for(i = 0 ; i < n +1 ; i++)
            Arrays.fill(dp[i],new BigInteger("-1"));

        /*      로직      */
        bw.write(use_dp(n,m).toString());
        bw.flush();
    }

    static BigInteger use_dp(int n , int m) {
        // 이미 과거에 갱신한적이 있다면 OK
        if (!(dp[n][m].toString()).equals("-1"))
            return dp[n][m];

        if(n == m || m == 0)
            dp[n][m] = new BigInteger("1");
        else
            dp[n][m] = use_dp(n - 1, m - 1).add(use_dp(n - 1, m));
        return dp[n][m];
    }

}
