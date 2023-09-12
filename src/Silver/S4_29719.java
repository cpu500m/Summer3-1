package Silver;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class S4_29719 {

    public static final int DIV = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger result = new BigInteger("1");
        BigInteger div_val = new BigInteger("1");
        BigInteger d=  new BigInteger(String.valueOf(DIV));
        // m^n - (m-1)^n
        for (int i = 0; i < n; i++) {
            result = result.multiply(new BigInteger(String.valueOf(m)));
            div_val = div_val.multiply(new BigInteger(String.valueOf(m-1)));
            if(result.remainder(d).
                    compareTo(div_val.remainder(d)) > 0){
                result = result.remainder(d);
                div_val = div_val.remainder(d);
            }
        }
        result = result.subtract(div_val).remainder(d);
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
