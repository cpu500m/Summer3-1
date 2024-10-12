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
 * @fileName : S1_2302
 * @date : 2024-10-13
 */
public class S1_2302 {

    // 현재 dp 배열 내 마지막 요소가 자기자리에 있는가?
    private static final int IS_NOT_IN_THEIR_SEAT = 0;
    private static final int IS_IN_THEIR_SEAT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] isVipSeat = new boolean[N];

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            isVipSeat[num - 1] = true;
        }

        int[][] dp = new int[N][2];

        dp[0][IS_NOT_IN_THEIR_SEAT] = 0;
        dp[0][IS_IN_THEIR_SEAT] = 1;

        for (int i = 1; i < N; i++) {
            if (isVipSeat[i - 1] || isVipSeat[i]) {
                dp[i][IS_NOT_IN_THEIR_SEAT] = 0;
                dp[i][IS_IN_THEIR_SEAT] = dp[i - 1][IS_NOT_IN_THEIR_SEAT] + dp[i - 1][IS_IN_THEIR_SEAT];

            } else {
                dp[i][IS_NOT_IN_THEIR_SEAT] = dp[i - 1][IS_IN_THEIR_SEAT];
                dp[i][IS_IN_THEIR_SEAT] = dp[i - 1][IS_NOT_IN_THEIR_SEAT] + dp[i - 1][IS_IN_THEIR_SEAT];
            }
        }

        bw.write(String.valueOf(dp[N - 1][IS_NOT_IN_THEIR_SEAT] + dp[N-1][IS_IN_THEIR_SEAT]));
        bw.flush();
    }
}
