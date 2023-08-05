package Bronze;

import java.io.*;

public class B2_2028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int p_s = Integer.parseInt(s);
            String d = String.valueOf(p_s*p_s);
            if(d.substring(d.length()-s.length(),d.length()).equals(s))
                sb.append("YES\n");
            else sb.append("NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
