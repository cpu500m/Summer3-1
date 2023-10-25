package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] token = {"AAAA", "BB"};
        StringTokenizer st = new StringTokenizer(br.readLine(), ".", true);
        while (st.hasMoreElements()) {
            String cur = st.nextToken();
            int len = cur.length();
            // . 토큰이면 그냥 붙임
            if(cur.charAt(0) == '.') {
                sb.append(cur);
                continue;
            }
            // 덮을 수 없는경우
            if(len % 2 !=0){
                sb.setLength(0);
                break;
            }

            for (int i = 0; i < len / token[0].length(); i++) {
                sb.append(token[0]);
            }
            len %= token[0].length();
            for (int i = 0; i < len / token[1].length(); i++) {
                sb.append(token[1]);
            }
        }
        if(sb.length() == 0) sb.append("-1");
        bw.write(sb.toString());
        bw.flush();
    }
}
