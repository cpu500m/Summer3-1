package Bronze;

import java.io.*;
import java.math.BigInteger;

public class B3_5988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int i;
        BigInteger value;
        for(i = 0 ; i < N ; i++){
            value = new BigInteger(br.readLine());
                    if((value = value.remainder(new BigInteger("2"))).equals(new BigInteger("0"))){
                        sb.append("even\n");
                    }
                    else
                        sb.append("odd\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
