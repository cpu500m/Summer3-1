package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_11441 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 ( 걍 누적합)
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }

        // 로직
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken());
            sb.append((arr[e]-arr[s])+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
