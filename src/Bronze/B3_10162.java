package Bronze;

import java.io.*;

public class B3_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int a, b, c;

        a = t / 300;
        t %= 300;
        b = t / 60;
        t %= 60;
        c = t / 10;
        t %= 10;
        if (t > 0) {
            bw.write(String.valueOf(-1));
        }
        else {
            bw.write(a+" "+b+" "+c);
        }
        bw.flush();
    }
}
