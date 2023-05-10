package Bronze;

import java.io.*;

public class B5_15680 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n == 0) bw.write("YONSEI");
        else bw.write("Leading the Way to the Future");
        bw.flush();
    }
}
