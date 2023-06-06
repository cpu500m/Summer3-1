package Bronze;

import java.io.*;

public class B4_15372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            long n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(n*n)+"\n");
        }
        bw.flush();
    }
}
