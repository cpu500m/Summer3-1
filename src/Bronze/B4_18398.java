package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_18398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            int n = Integer.parseInt(br.readLine());
            for (int i  = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append((a+b)+" "+(a*b)+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
