package Bronze;

import java.io.*;

public class B5_10870 {
    private static int[] value;
    private static final int SIZE=  21;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        value = new int[SIZE];
        bw.write(String.valueOf(fibonacci(n)));
        bw.flush();
    }
    public static int fibonacci(int n){
        // DP 적용
        if(value[n] != 0)
            return value[n];
        if( n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n-1)+fibonacci(n-2);
    }
}
