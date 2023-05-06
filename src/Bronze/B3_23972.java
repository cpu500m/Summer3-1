package Bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B3_23972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        if(n == 1) bw.write("-1");
        else{
            BigInteger a = new BigInteger(String.valueOf(n)).multiply(new BigInteger(String.valueOf(k)));
            BigInteger res = a.divide(new BigInteger(String.valueOf(n-1)));
            BigInteger rm = a.remainder(new BigInteger(String.valueOf(n-1)));
            if(!rm.toString().equals("0")) {
                res = res.add(new BigInteger("1"));
            }
            bw.write(res.toString());
        }
        bw.flush();
    }
}
