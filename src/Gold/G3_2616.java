package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G3_2616
 * @date : 2024-09-15
 */
public class G3_2616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(br.readLine());

        // 누적합
        int[] sum = new int[n+1];
        // 1개만 고를때, 2개, 3개
        int[][] dp = new int[n+1][3];
        sum[0] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
            if(i >= size){
                int curSum = sum[i] - sum[i - size];
                dp[i][0] = Math.max(dp[i - 1][0], curSum);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-size][0] + curSum);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-size][1] + curSum);
            }
        }

        bw.write(String.valueOf(dp[n][2]));
        bw.flush();
    }
}
