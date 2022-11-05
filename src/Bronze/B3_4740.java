package Bronze;

import java.io.*;

public class B3_4740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        while (!str.equals("***")) {
            for (int i = str.length() - 1; i >= 0; i--)
                bw.write(str.charAt(i));
            bw.write("\n");
            str = br.readLine();
        }
        bw.flush();
    }
}
