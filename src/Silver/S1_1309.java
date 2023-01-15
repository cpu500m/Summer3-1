// 이게 좀 까다로워서 생각을 좀 많이했음.,.
// 흠.. 생각 해본결과 이제
// 무조건 진행하면서 배치를 한다고 생각하는거임.
// 그니깐
// N= 4일떄를 먼저 보면
// 다 비어있는경우 1
// N=     1     2      3    4
//   위   1      2      5    12
//  아래  1      2      5     12
// 처럼 하고 다 더하는거임.
// 에시로 N= 4일떄의 위는 어떻게 12라는값이도출됐는가?
// N=3일때의 5 + 이전의 모든값을 다 더하는거임. 왜냐면 그 모든 경우 + 자기 자리에 사자 놓는경우니깐.


package Silver;

import java.io.*;

public class S1_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // index
        int i;
        int result = 0;

        /*      로직      */
        int[][] dp = new int[2][N];

        dp[0][0] = 1;
        dp[1][0] = 1;
        // i-2번째 까지의 합을 저장해놓는 변수이다.
        int cur_sum = 1;
        for( i = 1 ; i < N ; i++){
            dp[0][i] = (dp[1][i-1]+cur_sum)%9901;
            dp[1][i] = (dp[0][i-1]+cur_sum)%9901;
            cur_sum+=((dp[0][i-1]+dp[1][i-1])%9901);
        }

        // 빈 경우
        result  += 1;
        for(i = 0 ; i < N ;i++) {
            result += (dp[0][i] + dp[1][i]);
            result%=9901;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
