package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int cnt = 1;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int cur_len = 1;
        for(int i = 1 ; i < N ; i++){
            int diff = (arr[i]-arr[i-1]);
            if(diff+cur_len > L){
                cnt++;
                cur_len = 1;
                continue;
            }
            cur_len += diff;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
