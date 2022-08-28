package Silver;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class S1_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(multiply(A,B,C)));
        bw.flush();
    }
    public static long multiply(int A, int B ,int C){
        if(B == 1)
            return A%C;
        long temp = multiply(A,B/2, C);
        BigInteger t = new BigInteger(String.valueOf(temp));
        if( B %2 == 0)
            return (temp*temp)%C;
        else
            return (((temp*temp)%C)*(A%C))%C;
    }
}
