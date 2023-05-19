package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_15963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        if (Long.parseLong(st.nextToken()) == Long.parseLong(st.nextToken())) {
            bw.write("1");
        }
        else bw.write("0");
        bw.flush();
    }
}
