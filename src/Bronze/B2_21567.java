package Bronze;

import java.io.*;
import java.math.BigInteger;

public class B2_21567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger c = new BigInteger(br.readLine());
        BigInteger res = a.multiply(b).multiply(c);
        String str = res.toString();
        int[] arr = new int[10];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)-'0']++;
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
