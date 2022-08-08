package Bronze;

import java.io.*;

public class B3_2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int mul1 = Integer.parseInt(br.readLine());
        String mul2 = br.readLine();
        int sum = 0;
        int up = 0;
        int val;
        for(int i = mul2.length()-1 ; i >= 0 ; i--){
            val = mul1*Character.getNumericValue(mul2.charAt(i));
            sb.append(val+"\n");
            sum += val*Math.pow(10,up++);
        }
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
    }
}
