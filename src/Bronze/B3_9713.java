package Bronze;

import java.io.*;

public class B3_9713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] cum_sum = new int[101];
        cum_sum[0] = 0;
        for(int i = 1 ; i < cum_sum.length ; i++){
            if( i %2 == 1)
                cum_sum[i] = i+cum_sum[i-1];
            else cum_sum[i] = cum_sum[i-1];
        }
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            bw.write(cum_sum[c]+"\n");
        }
        bw.flush();
    }
}
