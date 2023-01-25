package Bronze;

import java.io.*;

public class B2_1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str= br.readLine();
        int sum = 0;
        for(int i = 0 ; i < str.length() ; i++){
            int cur = (int)Math.pow(16,str.length()-i-1);
            if(Character.isDigit(str.charAt(i))){
                sum += ((str.charAt(i))-'0')*cur;
            }
            else sum+= (((str.charAt(i)-'A')+10)*cur);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
