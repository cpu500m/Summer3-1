package Bronze;

import java.io.*;

public class B5_30030 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int b = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(b*10 / 11));
        bw.flush();
    }
}
