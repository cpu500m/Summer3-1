package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] bucket = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int j = s-1; j < e; j++) {
                bucket[j] = c;
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(bucket[i] + " ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
