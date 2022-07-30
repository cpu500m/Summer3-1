// N이 10^6 일때 대략 12MB 언저리 잡힐것으로 예상
package Silver;

import java.io.*;

public class S2_1463 {
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        bw.write(String.valueOf(findOptimalCount(N)));
        bw.flush();
    }
    private static int findOptimalCount(int N) {
        if(N ==1)
            return 0;
        if(N ==2)
            return 1;
        dp[2] = 1; dp[3]=1;
        for (int i = 4; i <= N; i++) {
            if( i % 3 == 0 && i % 2 ==0 ) {
                dp[i] = Math.min(dp[i / 3], dp[i / 2]);
                dp[i] = Math.min(dp[i], dp[i - 1]) + 1;
            }
            else if( i % 3 == 0 ){
                dp[i] = Math.min(dp[i / 3], dp[i-1])+1;
            }
            else if( i % 2 == 0){
                dp[i] = Math.min(dp[i / 2], dp[i-1])+1;
            }
            else
                dp[i] = dp[i-1]+1;
        }
        return dp[N];
    }
}
