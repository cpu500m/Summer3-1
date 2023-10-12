package Bronze;

import java.io.*;

public class B3_30329 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int cnt = 0;
        for (int i = 0; i < str.length()-3; i++) {
            if(str.substring(i, i+4).equals("kick")) cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
