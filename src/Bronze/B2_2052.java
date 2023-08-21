package Bronze;

import java.io.*;
import java.math.BigDecimal;

public class B2_2052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        BigDecimal res = new BigDecimal("1");
        BigDecimal div = new BigDecimal(Math.pow(2, n));
        res = res.divide(div);
        bw.write(res.toPlainString());
        bw.flush();
    }
}
