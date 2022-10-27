package Bronze;

import java.io.*;

public class B3_2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum+=Integer.parseInt(br.readLine());
        }
        sum-=(N-1);
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
