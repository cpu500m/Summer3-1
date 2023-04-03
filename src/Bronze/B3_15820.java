package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_15820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean c = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (!st.nextToken().equals(st.nextToken())) {
                sb.append("Wrong Answer");
                c = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (!st.nextToken().equals(st.nextToken())) {
                if(c) break;
                sb.append("Why Wrong!!!");
                c = true;
                break;
            }
        }
        if(!c)
            sb.append("Accepted");
        bw.write(sb.toString());
        bw.flush();
    }
}
