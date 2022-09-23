package Bronze;

import java.io.*;

public class B1_2033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cur =10;
        int cur_val;
        while(true){
            if( N > cur){
                cur_val = N%cur;
                if(cur_val >= (5*(cur/10))) {
                    N += (cur - cur_val);
                }
                else
                    N -=cur_val;
                cur*=10;
            }
            else
                break;
        }
        bw.write(String.valueOf(N));
        bw.flush();
    }
}
