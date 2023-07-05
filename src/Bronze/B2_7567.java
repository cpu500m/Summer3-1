package Bronze;

import java.io.*;

public class B2_7567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int h = 10;
        char p = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == p)
                h += 5;
            else{
                h += 10;
                p = str.charAt(i);
            }
        }
        bw.write(String.valueOf(h));
        bw.flush();
    }
}
