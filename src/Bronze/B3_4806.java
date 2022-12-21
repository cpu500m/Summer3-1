package Bronze;

import java.io.*;

public class B3_4806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        while (br.readLine() != null) {
            cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}