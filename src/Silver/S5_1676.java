package Silver;

import java.io.*;

public class S5_1676 {
    static int two_count = 0;
    static int five_count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count;
        int N = Integer.parseInt(br.readLine());
        for(int i = 2; i <= N ; i++){
            fac(i);
        }
        count = Math.min(two_count,five_count);
        bw.write(String.valueOf(count));
        bw.flush();
    }
    public static void fac(int n) {
        int temp = n;
        while( n % 2 == 0){
            two_count++;
            n/=2;
        }
        while( n % 5 == 0){
            five_count++;
            n/=5;
        }
    }
}

