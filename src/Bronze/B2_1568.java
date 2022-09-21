package Bronze;

import java.io.*;

public class B2_1568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cur = 1;
        int sec = 0;
        while(N > 0){
            if(N-cur < 0)
                cur = 1;
            N-=(cur++);
            sec++;
        }
        bw.write(String.valueOf(sec));
        bw.flush();
    }
}
