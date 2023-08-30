package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_10833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int res = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int person_cnt = Integer.parseInt(st.nextToken());
            int total = Integer.parseInt(st.nextToken());
            res += (total % person_cnt);
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
