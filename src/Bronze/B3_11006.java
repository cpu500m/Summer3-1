package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_11006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt1;
            for (cnt1 = 0; cnt1 < m; cnt1++) {
                if(cnt1*1 + (m-cnt1)*2 == n)
                    break;
            }
            sb.append(cnt1+" "+(m-cnt1)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
