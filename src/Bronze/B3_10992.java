package Bronze;

import java.io.*;
import java.util.Arrays;

public class B3_10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int e2_cnt = -1;
        for(int i = 1 ; i < N ; i++){
            int empty_cnt = N-i;
            for(int j = 0 ; j < empty_cnt ; j++)
                bw.write(" ");
            bw.write("*");
            for(int j = 0 ; j < e2_cnt ; j++)
                bw.write(" ");
            if(e2_cnt != -1)
                bw.write("*\n");
            else bw.write("\n");
            e2_cnt+=2;
        }
        for(int i = 0; i < N*2-1; i++)
            bw.write("*");
        bw.flush();
    }
}
