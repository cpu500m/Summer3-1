package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count =0;
        while (st.hasMoreTokens()) {
            st.nextToken();
            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
