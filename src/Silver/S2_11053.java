package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_11053 {
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(getMinLength(N)));
        bw.flush();
    }

    private static int getMinLength(int N) {
        dp[1] = 1;
        int max_len = -1;
        for (int i = 2; i <= N; i++) {
                for (int j = 1; j < i; j++) {
                    if (arr[j] < arr[i] && max_len < dp[j]) {
                        max_len = dp[j];
                        dp[i] = dp[j] + 1;
                    }
                }
                if(max_len == -1)
                    dp[i] = 1;
                max_len = -1;
            }
        for(int i =  1; i <= N ;i++){
            if(max_len < dp[i])
                max_len = dp[i];
        }
        return max_len;
    }
}
