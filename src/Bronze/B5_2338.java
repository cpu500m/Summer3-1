package Bronze;

import java.io.*;
import java.math.BigInteger;

public class B5_2338 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        sb.append(a.add(b)+"\n"+a.subtract(b)+"\n"+a.multiply(b));
        bw.write(sb.toString());
        bw.flush();
    }
}
