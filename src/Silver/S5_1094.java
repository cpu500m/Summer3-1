package Silver;

import java.io.*;

public class S5_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cur = 64;
        int cnt = 0 , sum = 0;
        while(sum != n){
            if(cur > n){
                cur /= 2;
                continue;
            }
            else{
                if(sum+cur > n){
                    cur /=2 ;
                    continue;
                }
                else{
                    sum += cur;
                    cnt++;
                    cur /=2;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
