package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S3_11726
 * @date : 2024-11-15
 */
public class S3_11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3 ; i <= n ; i++){
            // 2칸 남기고 누운거 2개 붙이던가
            // 1칸 남기고 세운거 한개 붙이던가
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 10007;
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }
}
