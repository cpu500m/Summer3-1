package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_4796 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int cnt = 1;
        while (l != 0) {

            int ans = (v/p)*l;
            ans += (v%p < l ? v%p : l);

            sb.append("Case "+(cnt++)+": "+ans+ "\n");

            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
