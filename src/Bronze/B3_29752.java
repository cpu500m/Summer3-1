package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_29752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;
        int cur = 0;

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st.nextToken()) != 0) {
                cur++;
            } else cur = 0;
            if(cur > ans) ans = cur;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
