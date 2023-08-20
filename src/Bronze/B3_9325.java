package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_9325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < TC; tc++) {
            int p = Integer.parseInt(br.readLine());
            int opt = Integer.parseInt(br.readLine());
            for (int i = 0; i < opt; i++) {
                st = new StringTokenizer(br.readLine());
                p += (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
            }
            sb.append(p + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
