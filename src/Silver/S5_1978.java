package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_1978 {
    private static int SIZE = 1001;
    public static void main(String[] args) throws IOException {
        boolean[] isPrime = new boolean[SIZE];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop_count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prime_count=0;
        eratosthenes(isPrime);
        for(int i =0; i< loop_count; i++)
            if(isPrime[Integer.parseInt(st.nextToken())])
                prime_count++;
            bw.write(String.valueOf(prime_count));
            bw.flush();
    }
    static void eratosthenes(boolean[] isPrime){
        // 1. 모두 소수로 체크 해줌
        for(int i =2; i<SIZE ; i++)
            isPrime[i] =true;
        // 2. 소수가 아닌애들 체크
        for(int i = 2; i <SIZE; i++){
            if(!isPrime[i])
                continue;
            for(int j = 2*i ; j < SIZE ; j+=i){
                isPrime[j] = false;
            }
        }
    }
}
