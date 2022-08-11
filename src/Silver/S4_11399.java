package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] cum_sum  = new int[N];
        int sum = 0;
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        cum_sum[0] = arr[0];
        for(int i = 1 ; i < N ; i++)
            cum_sum[i] = cum_sum[i-1]+arr[i];
        for(int i = 0; i <N; i++)
            sum+=cum_sum[i];
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
