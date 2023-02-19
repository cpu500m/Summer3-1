package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_17388 {
    final static int S = 0;
    final static int K = 1;
    final static int H = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        int min = 100 , min_idx= -1;
        int cur;
        for(int i = 0 ; i < 3;  i++){
            cur = Integer.parseInt(st.nextToken());
            total += cur;
            if(cur < min) {
                min = cur;
                min_idx = i;
            }

        }
        if(total >= 100)
            bw.write("OK");
        else{
            if(min_idx == S)
                bw.write("Soongsil");
            else if(min_idx == K)
                bw.write("Korea");
            else bw.write("Hanyang");
        }
        bw.flush();
    }
}
