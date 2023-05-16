package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_2476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cnt = new int[7];
            int max_v = 0, max_c = 0, val = 0;
            for (int j = 0; j < 3; j++) {
                int c = Integer.parseInt(st.nextToken());
                cnt[c]++;
                if (max_c < cnt[c]) {
                    max_c = cnt[c];
                    max_v = c;
                }
                else if(max_c == cnt[c])
                    if(max_v < c)
                        max_v = c;
            }
            if (max_c == 3) {
                val = 10_000 + max_v * 1_000;
                res = res > val ? res : val;
            } else if (max_c == 2) {
                val = 1_000 + max_v * 100;
                res = res > val ? res : val;
            }
            else{
                val = 100 * max_v;
                res = res > val ? res : val;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
