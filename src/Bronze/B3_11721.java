package Bronze;

import java.io.*;

public class B3_11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        for(int i = 1 ; i <= str.length() ; i++){
            bw.write(str.charAt(i-1));
            if( i % 10 == 0)
                bw.write("\n");
        }
        bw.flush();
    }
}
