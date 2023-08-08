package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1333 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        // 0~ L , (L+5) ~ (2L +5) , 2L+ 10 , 3L + 10
        // loop_var -> i 치환
        // i번째 = i*(L+5)~ (i+1)L + i * 5
        int cur = 1;
        for (int i = 0; i < n; i++) {
            int start_t = i * (l + 5);
            int end_t = (i + 1) * l + i * 5;
            int alert_t = cur * d;
            // 전화벨 울리는 시간이 이번주기랑 관계 없다면
            if (alert_t > end_t) {
                continue;
            }
            if (start_t > alert_t || alert_t == end_t ) break;
            else{
                while (cur *d < end_t) cur++;
            }
        }
        bw.write(String.valueOf(cur * d));
        bw.flush();
    }
}
