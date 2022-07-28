package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] cum_sum = new int[n];
        int max_value = Integer.MIN_VALUE;
        for(int i = 0; i <n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        cum_sum[0] =arr[0];
        for(int i =1 ; i < n ; i++){
            cum_sum[i] = Math.max(cum_sum[i-1]+arr[i], arr[i]);
        }
        for(int i = 0 ; i < n ; i++) {
            if(max_value < cum_sum[i])
                max_value = cum_sum[i];
        }
        bw.write(String.valueOf(max_value));
        bw.flush();
    }
}
