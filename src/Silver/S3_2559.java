package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] cum_sum = new int[N+1];
        int cmp_value;
        int max_value = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cum_sum[i+1] = cum_sum[i]+arr[i];
        }
        for(int i = K; i <= N ; i++){
            cmp_value = cum_sum[i] - cum_sum[i-K];
            if(max_value < cmp_value)
                max_value = cmp_value;
        }
        bw.write(String.valueOf(max_value));
        bw.flush();
    }
}
