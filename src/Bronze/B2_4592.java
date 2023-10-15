package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_4592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n;
        while ((n = Integer.parseInt(st.nextToken())) != 0) {
            int pre = -1;
            for (int i = 0; i < n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur != pre){
                    pre = cur;
                    sb.append(cur+" ");
                }
            }
            sb.append("$\n");
            st = new StringTokenizer(br.readLine());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
