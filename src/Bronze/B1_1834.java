package Bronze;

import java.io.*;
import java.math.BigInteger;

public class B1_1834 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger sum = new BigInteger("0");
        int n = Integer.parseInt(br.readLine());
        BigInteger cur = new BigInteger(String.valueOf(n+1));
        for(int i = 1 ; i < n ; i++){
            sum = sum.add(cur);
            cur = cur.add(new BigInteger(String.valueOf(n+1)));
        }
        bw.write(sum.toString());
        bw.flush();
    }
}
