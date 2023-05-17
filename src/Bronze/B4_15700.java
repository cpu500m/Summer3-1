package Bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B4_15700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken()).multiply(new BigInteger(st.nextToken()));
        bw.write(String.valueOf(n.divide(new BigInteger("2"))));
        bw.flush();
    }
}
