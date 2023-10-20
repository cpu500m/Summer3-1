package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_5751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cnt = new int[2];
            for (int i = 0; i < n; i++) {
                cnt[Integer.parseInt(st.nextToken())]++;
            }
            sb.append("Mary won "+cnt[0]+" times and John won "+cnt[1]+" times\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
