package Bronze;

import java.io.*;

public class B4_21612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int b = Integer.parseInt(br.readLine());
        int v = 5 * b - 400;
        sb.append(v+"\n"+ (v == 100 ? 0 : (v > 100 ? -1 : 1)));
        bw.write(sb.toString());
        bw.flush();
    }
}
