package Bronze;

import java.io.*;

public class B4_6749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a1 = Integer.parseInt(br.readLine());
        int a2 = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(a2+ (a2-a1)));
        bw.flush();
    }
}
