package Bronze;

import java.io.*;
import java.math.BigInteger;

public class B5_27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        BigInteger s = new BigInteger("1");
        for(int i = 1 ; i <= n ; i++){
            s = s.multiply(new BigInteger(String.valueOf(i)));
        }
        bw.write(s.toString());
        bw.flush();
    }
}
