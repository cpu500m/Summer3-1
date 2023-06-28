package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_9501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int f = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                double m = v / (double)c;
                cnt = m*f >= d  ? cnt+1 : cnt;
            }
            sb.append(String.valueOf(cnt));
            if( tc != TC-1)
                sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
