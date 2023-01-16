// 걍 에라토스테네스의 체로 한번 거르고 두 포인터 쓰면 끝일듯
// 시간복잡도 O(n)으로 해야할듯 N이 워낙커서..
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G3_1644 {

    // 소수가 아니면 true, 소수면 false. 처음에 false로 초기화하니깐 편의상 글케하자 그냥..
    // 아 아니다 그냥 좀 더 걸려도 명확하게 가자
    // 소수면 true, 소수가 아니면 false로
    static boolean[] prime_num = new boolean[4_000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*  입력  처리  */
        // index
        int i;

        int N = Integer.parseInt(br.readLine());

        /*      로직      */
        // 답
        int result = 0;
        // 누적합
        int sum = 0;
        // 여기다가 소수 하나하나 넣을거임 ㅎㅎ
        Queue<Integer> queue  = new LinkedList<>();
        // 우선 소수를 먼저 거른다
        eratosthenes();

        // N부터 시작해서 하나 뺄셈 하더라도 하나만 빼도록. 왜냐면 오름차순으로 하면은
        // 큐에있던거 한번에 두 개 이상 빼야될 수도 있음.
        for(i = N ; i > 1 ; i--){
            // 소수라면 누적합에 추가
            if(prime_num[i]){
                if( (sum + i) > N){
                    sum-=queue.poll();
                }
                else if( (sum+i) == N)
                    result++;
                sum+= i;
                queue.add(i);
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static void eratosthenes(){
        Arrays.fill(prime_num,true);
        // index
        int i, j;

        for(i = 2; i <= 4_000_000 ; i++){
            if(prime_num[i] == false)
                continue;

            for( j = 2*i ; j <= 4_000_000; j+=i)
                prime_num[j] = false;
        }
    }
}
