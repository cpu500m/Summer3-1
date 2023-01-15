package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class G3_27212 {
    // 메모리도 넉넉하고 N , M도 최대 1000인 것이 DP로 풀면 아주 딱일듯
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // index
        int i,j,k;

        /*      입력  처리      */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] weight = new int[C+1][C+1];
        int[] n_per = new int[N];
        int[] m_per = new int[M];

        for( i = 1; i <= C ;i++){
            st = new StringTokenizer(br.readLine());
            for( j =1 ; j<=C ; j++)
                weight[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for( i = 0 ; i < N ; i++)
            n_per[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(i = 0 ; i < M ; i++)
            m_per[i] = Integer.parseInt(st.nextToken());

        /*      로직      */
        // 점화식을 세워보자...
        //dp[i][j] = j > k인  dp[i-1][k] 에서의 max값. ( k = 1, 2, 3,... , j-1) + 현재 악수
        // 왜틀렸나 생각해봤더니 악수를 스킵하는 경우도있는거임.

        long[][] dp = new long[N+1][M+1];
        long pre_max;
        long result = 0;

        // 0으로 초기화
        for( i = 0 ; i < N +1 ; i++)
            Arrays.fill(dp[i] , 0);

        for( i = 1 ; i <= N ; i++){
            pre_max = 0;
            for( j = 1 ; j <= M ; j++){
                if(dp[i-1][j-1] > pre_max)
                    pre_max = dp[i-1][j-1];
                dp[i][j] = Math.max(weight[n_per[i-1]][m_per[j-1]]+pre_max, dp[i-1][j]);
                if(result < dp[i][j])
                    result = dp[i][j];
            }
        }

//        for( i = 1 ; i <= N ; i++){
//            for(j = 1 ; j<= M ; j++)
//                bw.write(dp[i][j]+" ");
//            bw.write("\n");
//        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
