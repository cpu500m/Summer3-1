package Bronze;

import java.io.*;

public class B4_30868 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt / 5; j++) {
                sb.append("++++ ");
            }
            for (int j = 0; j < cnt % 5; j++) {
                sb.append("|");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
