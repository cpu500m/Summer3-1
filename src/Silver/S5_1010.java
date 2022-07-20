package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int loop_count = Integer.parseInt(br.readLine());
        int N,M;
        for(int i = 0 ; i <loop_count ; i++){
            st= new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sb.append(getBin(M,N)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int getBin(int n , int k ) {
        int[][] arr = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= Math.min(i, k); j++){
                if (j == 0 || i == j)
                    arr[i][j] = 1;
                else
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]);
            }
        return arr[n][k];
    }
}
