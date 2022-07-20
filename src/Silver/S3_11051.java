package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) , K = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(getBin(N,K)));
        bw.flush();
    }
    public static int getBin(int n , int k ) {
        int[][] arr = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= Math.min(i, k); j++){
                if (j == 0 || i == j)
                    arr[i][j] = 1;
                else
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j])%10_007;
            }
        return arr[n][k];
    }
}
