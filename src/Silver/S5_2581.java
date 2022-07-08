package Silver;

import java.io.*;

public class S5_2581 {
    private static int SIZE = 10001;
    public static void main(String[] args) throws IOException {
        boolean[] isPrime = new boolean[SIZE];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        int sum=0;
        int min = Integer.MAX_VALUE;
        eratosthenes(isPrime);
        for(int i =start; i< end+1; i++) {
            if (isPrime[i]) {
                sum += i;
                if(min > i)
                    min = i;
            }
        }
        if(sum == 0) {
            bw.write("-1");
        }
        else
            bw.write(String.valueOf(sum)+"\n"+String.valueOf(min));
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
