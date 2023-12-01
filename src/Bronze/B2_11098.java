package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_11098 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int p = -1;
            String name = "-";
            for (int j  = 0;  j<n ; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cur = Integer.parseInt(st.nextToken());
                if (p < cur) {
                    p =cur;
                    name = st.nextToken();
                } else st.nextToken();
            }
            sb.append(name + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
