package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_21300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < 6; i++) {
            total += Integer.parseInt(st.nextToken())*5;
        }
        bw.write(String.valueOf(total));
        bw.flush();
    }
}
