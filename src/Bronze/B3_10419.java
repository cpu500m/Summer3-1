package Bronze;

import java.io.*;

public class B3_10419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            int n = Integer.parseInt(br.readLine());
            int start = (int)Math.sqrt((double)n);
            for (int i = start; i >= 0; i--) {
                if(i*i + i <= n) {
                    sb.append(i + "\n");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
