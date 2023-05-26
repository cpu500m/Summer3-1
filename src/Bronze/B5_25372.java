package Bronze;

import java.io.*;

public class B5_25372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if( str.length() <6 || str.length() > 9)
                bw.write("no\n");
            else bw.write("yes\n");
        }
        bw.flush();
    }
}
