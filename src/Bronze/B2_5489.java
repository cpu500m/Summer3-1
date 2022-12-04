package Bronze;

import java.io.*;

public class B2_5489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int max = 0, max_v = 0;
        int[] check = new int[10001];
        int i;
        for(i = 0 ; i < n ; i++){
            check[Integer.parseInt(br.readLine())]++;
        }
        for(i = 1; i < 10001 ; i++){
            if( max < check[i]) {
                max = check[i];
                max_v = i;
            }
        }
        bw.write(String.valueOf(max_v));
        bw.flush();
    }
}
