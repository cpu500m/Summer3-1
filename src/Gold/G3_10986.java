// N의 최댓값은 1,000,000
// 제일먼저 생각나는 방식은 N개만큼의 int 배열을 만들고 (4MB)
// 각각에 나머지를 합한 누적 나머지를 저장
// ( 그니까 arr[1]에 A1을 M으로 나눈 나머지를.
// arr[2]에 (A1의 나머지 + A2 나머지) % M
// .. 이런식으로.
// 그리고 cum_sum (arr) 을 1에서 N까지 순회하며
// cum_sum 값이 0일때 마다 cnt를 ++ 해주고 ,
// 만약 이전 cum_sum도 0이었다면 cnt를 하나더 ++해줌.
// 그리고 zero_count를 기록해 가면서
// zero_count 값만큼 cnt를 더 ++ 해줌 ( 이유는 그만큼의 M으로 나누어 떨어지는 부분을 만들 수 있다는 뜻이기 때문)

// 근데 윗방식대로 하니깐 1 2 3 1 2 같은 경우 2 3 1 을 카운트하지 못하는 그런 경우가 발생함.
// 그래서 어떻게 해야할까 곰곰히 생각해봤는데
// 예를들어 1 2 3 1 2 의 경우 누적 나머지는
// 1 0 0 1 0 인데
// 1~ 다음 1 까지 가 2 3 1 을 나타낸다는것에서 아이디어를 얻음.
// 그냥 나머지 만큼의 크기의 배열을 만들어서 각각 카운트하면서
// 최종 결과를 계산해주면 될것같음.
package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G3_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long cnt=0;
        st = new StringTokenizer(br.readLine());
        int[] cum_sum = new int[N];
        int[] remainder = new int[M];
        cum_sum[0] = Integer.parseInt(st.nextToken())%M;
        remainder[cum_sum[0]]++;
        for(int i = 1 ; i < N ; i++){
            cum_sum[i] = (cum_sum[i-1]+Integer.parseInt(st.nextToken()))%M;
            remainder[cum_sum[i]]++;
        }
        while(remainder[0] > 0)
            cnt+=(remainder[0]--);
        for(int i = 1 ; i < M ; i++)
            while(remainder[i] > 1)
                cnt+=(--remainder[i]);
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
