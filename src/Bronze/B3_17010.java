package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_17010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            for (int j = 0; j < n; j++) {
                sb.append(c);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
