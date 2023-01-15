
// 작은문제로 쪼개서 해결하면될듯
// 2행짜리 만들어서 왼쪽 , 오른쪾 경우 저장하면서 진행하면 되곘다 DP느낌으로다가

package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class G5_27210 {
    final static int LEFT = 1;
    final static int RIGHT = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index
        int i;

        int result = 0;

        /*  입력 처리   */
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // 0행을 left , 1행을 right로
        int[][] dp = new int[2][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        /*      로직      */
        // dp내부 0으로 초기화
        for( i = 0 ; i <2 ; i++)
            Arrays.fill(dp[i], 0);

        for( i = 1 ; i <= N ; i++){
            if(arr[i-1] == LEFT){
                dp[0][i] = dp[0][i-1]+1;
                dp[1][i] = dp[1][i-1]-1;
                if(dp[1][i] < 0)
                    dp[1][i] = 0;
                if(dp[0][i] < 0)
                    dp[0][i] = 0;
            }
            else{
                dp[1][i] = dp[1][i-1]+1;
                dp[0][i] = dp[0][i-1]-1;
                if(dp[0][i] < 0)
                    dp[0][i] = 0;
                if(dp[1][i] < 0)
                    dp[1][i] = 0;
            }
        }

        for( i = 1 ; i <= N ; i++){
            if( result < Math.max(dp[0][i], dp[1][i]))
                result = Math.max(dp[0][i], dp[1][i]);
        }
//            for(int j = 1 ; j <= N ; j++)
//                bw.write(dp[0][j]+" "+dp[1][j]+"\n");

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
