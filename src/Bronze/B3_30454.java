package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_30454 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        int max_len = 0;
        int[] cnt = new int[1000];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "0");
            int size = st.countTokens();
            if(size >= max_len) {
                max_len = size;
                cnt[size]++;
            }
        }
        bw.write(max_len+" "+cnt[max_len]);
        bw.flush();
    }
}
