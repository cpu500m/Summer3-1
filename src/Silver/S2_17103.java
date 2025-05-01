package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S2_17103
 * @date : 25. 5. 1.
 */
public class S2_17103 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /* 사전 처리 */
        Set<Integer> primeSet = getPrimeSet();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int number = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j = 2; 2*j <= number; j++) {
                if(primeSet.contains(j) && primeSet.contains(number - j)) {
                    count++;
                }
            }
            sb.append(count + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static Set<Integer> getPrimeSet() {
        boolean[] isPrime = new boolean[1_000_001];

        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2 ; i * i <= isPrime.length ; i++) {
            if(!isPrime[i]) continue;

            for (int j = i*i; j < isPrime.length; j+=i) {
                isPrime[j] = false;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < isPrime.length; i++) {
            if(isPrime[i]){
                set.add(i);
            }
        }
        return set;
    }
}
