package Bronze;

import java.io.*;

public class B2_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int sum=0;
        String str;
        for(int i = 1; i < N ; i++){
            sum+=i;
            str= String.valueOf(i);
            for(int j = 0 ; j < str.length(); j++){
                sum+=Character.getNumericValue(str.charAt(j));
            }
            if(sum == N){
                bw.write(String.valueOf(i));
                bw.flush();
                return ;
            }
            sum = 0;
        }
        bw.write("0");
        bw.flush();
    }
}
