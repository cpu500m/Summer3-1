package Silver;

import java.io.*;

public class S2_9020 {
    private static final int SIZE = 246_913;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop_count = Integer.parseInt(br.readLine());
        int count = 0;
        int n = 0;
        boolean[] isPrime = new boolean[SIZE];
        eratosthenes(isPrime);
        for(int i =0; i <loop_count ; i++){
            n = Integer.parseInt(br.readLine());
            for (int j = n/2; j > 0 ; j--) {
                if (isPrime[j])
                    if (isPrime[n - j]){
                        bw.write(String.valueOf(j) + " " + String.valueOf(n - j)+"\n");
                        break;
                    }
            }
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
