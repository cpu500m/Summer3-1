package Silver;

import java.io.*;

public class S2_4948 {
    private static final int SIZE = 246_913;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());
        int count = 0;
        boolean[] isPrime = new boolean[SIZE];
        eratosthenes(isPrime);
        while( n != 0) {
            for (int i = n+1; i < (2*n + 1); i++){
                if (isPrime[i])
                    count++;
            }
            bw.write(String.valueOf(count) + "\n");
            count = 0;
            n = Integer.parseInt(br.readLine());
        }
        bw.flush();
    }
    public static void eratosthenes(boolean[] isPrime){
        for(int i=2 ; i< SIZE ; i++)
            isPrime[i] = true;
        for(int i = 2; i < SIZE ; i++){
            if(!isPrime[i])
                continue;
            for(int j = 2*i;  j < SIZE ; j+=i)
                isPrime[j] = false;
        }
    }
}
