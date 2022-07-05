package Bronze;

import java.io.*;

public class B4_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str= br.readLine();
        int sum=0;
        for(int i = 0; i < n ; i++){
            sum+=Character.getNumericValue(str.charAt(i));
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
