package Bronze;

import java.io.*;

public class B1_24416 {
    private static int recur_count = 0, dp_count = 0;
    private static int[] f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        f = new int[n+1];
        fib(n);
        fibonacci(n);
        bw.write(recur_count+" "+dp_count);
        bw.flush();
    }
    public static int fib(int n){
        if(n==1 || n == 2) {
            recur_count++;
            return 1;
        }
        else return (fib(n-1)+(fib(n-2)));
    }
    public static int fibonacci(int n){
        f[1] =1;
        f[2]= 1;
        for(int i = 3; i <= n ; i++){
            dp_count++;
            f[i] = f[i-1]+f[i-2];
        }
        return f[n];
    }
}
