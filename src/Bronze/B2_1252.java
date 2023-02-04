package Bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B2_1252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a =  st.nextToken();
        String b = st.nextToken();
        BigInteger sum = new BigInteger(a,2).add(new BigInteger(b,2));
        bw.write(sum.toString(2));
        bw.flush();
    }
}
