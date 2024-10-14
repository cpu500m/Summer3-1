package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_2666
 * @date : 2024-10-14
 */
public class G5_2666 {

    private static final int MAX =123456789;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        //시작 값 세팅
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        int len = Integer.parseInt(br.readLine());

        int[][][] dp = new int[len+1][N+1][N+1];

        for (int i = 0; i < len + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                Arrays.fill(dp[i][j], MAX);
            }
        }

        dp[0][node1][node2] = 0;

        for (int i = 0; i < len; i++) {
            int target = Integer.parseInt(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    if(dp[i][j][k] == MAX) continue;
                    dp[i+1][target][k] = Math.min(dp[i+1][target][k],dp[i][j][k] + Math.abs(target - j));

                    dp[i + 1][j][target] = Math.min(dp[i + 1][j][target],dp[i][j][k] + Math.abs(target - k));
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if(dp[len][i][j] == -1) continue;
                if(dp[len][i][j] < result) result = dp[len][i][j];
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
