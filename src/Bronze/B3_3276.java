package Bronze;

import java.io.*;

public class B3_3276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int opt = 1000;
        int[] result = new int[2];
        for (int i = 1; i <= n; i++) {
            int col = n/i;
            if(n % i !=0) col++;
            if(i + col < opt) {
                opt = i + col;
                result[0] = i;
                result[1] = col;
            }
        }
        bw.write(result[0] + " " + result[1]);
        bw.flush();
    }
}
