package Bronze;

import java.io.*;

public class B5_2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str= br.readLine();
        int result = 0;
        for(int i =0 ; i < 9 ; i+=2)
            result+= Character.getNumericValue(str.charAt(i))*Character.getNumericValue(str.charAt(i));
        result %= 10;
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
