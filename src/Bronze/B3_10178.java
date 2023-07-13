package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_10178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            int dividend = Integer.parseInt(st.nextToken());
            int divisor = Integer.parseInt(st.nextToken());
            sb.append("You get " + dividend / divisor + " piece(s) and your dad gets " + dividend % divisor + " piece(s).\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
