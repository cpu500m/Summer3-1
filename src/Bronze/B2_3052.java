/* 2022-06-28*/
package Bronze;

import java.io.*;

public class B2_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] remain = new int[10];
        int dup=0;
        int val;
        boolean check;
        for(int i =0; i<10; i++){
            check=false;
            val = Integer.parseInt(br.readLine());
            remain[i] = val%42;
            for(int j = 0; j < i ; j++) {
                if (remain[i] != remain[j]) {
                   continue;
                }
                else {
                    check=true;
                    break;
                }
            }
            if(!check)
                dup++;
        }
        bw.write(String.valueOf(dup));
        bw.flush();
    }
}
