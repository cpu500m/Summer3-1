package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_10984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int total = 0;
            double score = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                total += c;
                score += Double.parseDouble(st.nextToken())*c;
            }
            sb.append(total + " " + String.format("%.1f" , score/total) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
