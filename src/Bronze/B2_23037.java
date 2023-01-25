package Bronze;

import java.io.*;

public class B2_23037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int sum = 0;
        for(int i = 0 ; i <str.length() ; i++){
            sum+= (int)Math.pow(str.charAt(i)-'0', 5);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
