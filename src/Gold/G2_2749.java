/* 2022-06-24 5번째 푼 문제 */
// 한번 연산했던 값을 다시 한번 연산한다면 시간제한이 1초이므로 반드시 시간 제한에 걸릴 것임.
// 그래서 한번 연산했던 값을 다시 연산하지않고 재사용 할 수있는 방식을 써야 함.
// 그런 면에서 divide and conquer는 적절하지 않은 것 같고 dynamic programming 방식을 생각.
// int 배열에 저장한다고 생각하고 모든 피보나치 수를 저장하면 1,000,000,000,000,000,000 * 4 bytes인데 128MB를 초과함.
// 그래서 모든 피보나치 수를 저장할 수는 없음.
// 그래서 기존공간을 일정 주기마다 돌아가면서 공유하는 방식을 생각.
// % 100 이런식으로 일정주기마다 돌아가면서 .
// 그런데 조건을 보니 입력 수가 굉장히 크므로 1초 라는 시간제한에 풀기는 어렵다고 생각했음.
// 그래서 어떤 규칙이 있지 않을까 하고 찾아보니 피사노 주기 라는것을 찾음.
// ( 나누는 수를 (M = 10^k (k>2) ) 이라고 하면 주기는 15*10(k-1)
// 나누는 수가 10^6 이므로 주기는 15*10^5.
// 그래서 그냥 15*10^5 만큼의 배열에 미리 값을 써주고.
// (입력받은값 % 주기)번째 위치의 값을 출력해주면 될 것 같음.
// 그리고 자바의 integer형 중 가장 큰 건 long인데 얘는 8bytes의 범위를 표현 가능하니까
// 큰 수를 처리할 수 있는 특수 클래스를 찾아본 결과 math의 BigInteger 클래스를 발견.
// String형태로 입력을 받은 후 이를 Biginteger에 넘겨야할 것 같음.
package Gold;

import java.math.BigInteger;
import java.util.Scanner;

public class G2_2749 {
    private static final int CYCLE = 15*100_000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger input = new BigInteger(scanner.next());
        BigInteger cycle_value = new BigInteger(String.valueOf(CYCLE));
        int[] fib = new int[CYCLE];
        for(int i = 0 ; i < CYCLE ; i++){
            if( i >= 2){
                fib[i] = fib[i-1]+fib[i-2];
                if(fib[i] > 1_000_000)
                    fib[i] %= 1_000_000;
            }
            else if( i == 1)
                fib[i] = 1;
            else if (i == 0)
                fib[i] = 0;
        }
        input = input.remainder(cycle_value);
        int f_input = input.intValue();
        System.out.print(fib[f_input]);
    }
}
