package Bronze;

import java.io.*;

public class B2_1964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        final int M = 45678;
        int i;
        int result = 5;
        for(i = 1 ; i < n ; i++){
            result = (result + ((i+2)*3-2)) % M;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
