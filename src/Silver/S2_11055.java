package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_11055 {
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
        int max_val = -1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i] && max_val < dp[j]) {
                    max_val = dp[j];
                }
            }
            if(max_val == -1)
                dp[i] = arr[i];
            else
                dp[i] = max_val +arr[i];
            max_val = -1;
        }
        for(int i =  1; i <= N ;i++){
            if(max_val < dp[i])
                max_val = dp[i];
        }
        return max_val;
    }
}
