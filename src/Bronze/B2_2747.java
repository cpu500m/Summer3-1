package Bronze;

import java.io.*;

public class B2_2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] fib = new long[46];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2 ; i <= 45 ; i++)
            fib[i] = fib[i-2]+ fib[i-1];

        int n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(fib[n]));
        bw.flush();
    }
}
