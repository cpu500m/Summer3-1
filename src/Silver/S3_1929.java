package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_1929 {
    private static final int SIZE = 1_000_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] isPrime = new boolean[SIZE];
        eratosthenes(isPrime);
        for(int i = start ; i < end+1 ; i++)
            if(isPrime[i])
                bw.write(String.valueOf(i)+"\n");

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
