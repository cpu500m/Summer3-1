package Silver;

import java.io.*;

public class S2_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int minus_sum;
        String str = br.readLine();
        int i = 0;
        while( i < str.length() && str.charAt(i) != '-'){
            if(Character.isDigit(str.charAt(i)))
                sb.append(str.charAt(i));
            else{
                result += Integer.parseInt(sb.toString());
                sb.setLength(0);
            }
            i++;
        }
        // - 걷기용
        i++;
        result+=Integer.parseInt(sb.toString());
        sb.setLength(0);
        // -기호가 나온 이후
        while(i < str.length()) {
            minus_sum=0;
            while (i < str.length() && str.charAt(i) != '-') {
                if (Character.isDigit(str.charAt(i)))
                    sb.append(str.charAt(i));
                else {
                    minus_sum += Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
                i++;
            }
            minus_sum+= Integer.parseInt(sb.toString());
            sb.setLength(0);
            i++;
            result-=minus_sum;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
