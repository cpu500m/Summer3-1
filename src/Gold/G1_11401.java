// 페르마의 소정리
// a^(p-1)을 p로 나눈 나머지는 1임. ( p가 소수이고 a는 정수이며 p의 배수가 아닐 때)
package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G1_11401 {
    private static int P = 1_000_000_007;
    private static int N,K;
    private static long base;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        base = (factorial(N-K)*factorial(K))%P;
        long numerator = factorial(N);
        long denominator = div_denominator(P-2);
        bw.write(String.valueOf((numerator*denominator)%P));
        bw.flush();
    }
    private static long factorial(int n){
        long result = 1;
        while(n > 1){
            result*=n--;
            result %= 1_000_000_007;
        }
        return result;
    }
    private static long div_denominator(int count){
        if(count == 1)
            return base;
        long temp = div_denominator( count/2);
                if( count %2 ==0)
                    return (temp*temp)%P;
                else
                    return (((temp*temp)%P)*base)%P;
    }
}
