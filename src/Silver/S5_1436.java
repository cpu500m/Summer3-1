package Silver;

import java.io.*;

public class S5_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int i = 666;
        int cp = i;
        while(true){
            cp = i;
            while( cp > 665) {
                if (cp % 1000 == 666) {
                    count++;
                    break;
                }
                else
                    cp /=10;
            }
            if( count == N) {
                bw.write(String.valueOf(i));
                bw.flush();
                return;
            }
            i++;
        }
    }
}
