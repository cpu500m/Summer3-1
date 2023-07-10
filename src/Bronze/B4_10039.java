package Bronze;

import java.io.*;

public class B4_10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int s = 0;
        for (int i = 0; i < 5; i++) {
            int c = Integer.parseInt(br.readLine());
            c = c < 40 ? 40 : c ;
            s += c;
        }
        bw.write(String.valueOf(s/5));
        bw.flush();
    }
}
