package Bronze;

import java.io.*;
import java.math.BigInteger;

public class B3_1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N;
        BigInteger sum, b;
        StringBuilder sb =new StringBuilder();
        for(int i = 0 ; i < 3; i++){
            N = Integer.parseInt(br.readLine());
            sum = new BigInteger("0");
            for(int j = 0 ; j < N ; j++){
                b = new BigInteger(br.readLine());
                sum = sum.add(b);
            }
            if(sum.toString().equals("0"))
                sb.append("0\n");
            else if (sum.toString().charAt(0) == '-')
                sb.append("-\n");
            else
                sb.append("+\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
