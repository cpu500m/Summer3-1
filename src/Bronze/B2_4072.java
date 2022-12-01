package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_4072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String tok;
        int i;
        StringTokenizer st = new StringTokenizer(str);
        while(!str.equals("#")) {
            while (st.hasMoreElements()) {
                tok = st.nextToken();
                for (i = tok.length() - 1; i >= 0; i--) {
                    sb.append(tok.charAt(i));
                }
                sb.append(" ");
            }
            str = br.readLine();
            st = new StringTokenizer(str);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
