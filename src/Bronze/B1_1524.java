package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_1524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 0; tc < TC; tc++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int s = 0;
            int b = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                if (s < cur) s=cur;
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int cur = Integer.parseInt(st.nextToken());
                if (b < cur) b=cur;
            }
            sb.append((s < b ? "B" : "S") + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
