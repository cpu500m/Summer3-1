package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_30402 {

    public static final int SIZE = 15;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                char c = st.nextToken().charAt(0);
                if (c == 'w') {
                    sb.append("chunbae");
                    break;
                }
                else if (c == 'b'){
                    sb.append("nabi");
                    break;
                }
                else if (c == 'g'){
                    sb.append("yeongcheol");
                    break;
                }
            }
            if(sb.length() != 0) break;
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
