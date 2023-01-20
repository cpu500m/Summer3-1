// 첫 집과 마지막 집의 색이 달라야 한다는거 하나떄문에 골드4같은데
// 그냥 3차원 배열 만들어서 첫 집의 색을 기록해두면 되는거 아닐까싶네
// 그러면 최악 1000*3*3*(내부 연산) 이니깐..ㅇㅋ 크게보면 O(N)이긴한데.. 아무튼 충분
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_17404 {
    final static int RED = 1;
    final static int GREEN = 2;
    final static int BLUE = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*  입력  처리  */
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        // 2,3차원에서 2칸은 조건문 만들기 귀찮으니깐 걍 더쓰자..
        int[][][] dp = new int[N][3+2][3+2];
        // index
        int i , j,k, a;
        for(i = 0 ; i < N ; i++){
            st= new StringTokenizer(br.readLine());
            for( j = 0 ; j < 3 ; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        /*  로직  */
        // 일단.. 3차원 공간은 첫집의 색깔을 기록해두는 용도로 쓸거임
        // 굉장히 큰값으로 채워 일단
        for(i = 0 ;  i<N ; i++)
            for(j = 0 ; j < 5; j++)
                Arrays.fill(dp[i][j],1_000_001);

        // 첫행은 그냥 각각 칠한 경우가 최적이니깐 그대로 가고
        for( i = 1 ; i <=3 ;i++)
            dp[0][i][i] = cost[0][i-1];

        // 점화식을 세워보자
        for(i = 1 ; i < N ; i++){
            for( j = 1 ; j <=3 ; j++){
                for(k = 1; k <=3 ; k++){
                    for( a = 1 ; a<=3 ; a++) {
                        if(a == j)
                            continue;
                        if (dp[i][j][k] > (dp[i - 1][a][k] + cost[i][j-1]))
                            dp[i][j][k] = dp[i - 1][a][k] + cost[i][j-1];
                    }
                }
            }
        }
        int result = 1_000_001;
        for( i = 1;  i<= 3 ; i++)
            for(j= 1 ; j <= 3 ; j++) {
                if( i == j) continue;
                if (result > dp[N - 1][i][j])
                    result = dp[N - 1][i][j];
            }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
