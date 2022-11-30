package Bronze;

import java.io.*;

public class B5_4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        if( str1.length() >= str2.length())
            bw.write("go");
        else
            bw.write("no");
        bw.flush();
    }
}
