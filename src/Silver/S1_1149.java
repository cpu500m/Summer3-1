// 매 순간 뭔색으로 칠하냐에따라 누적 합을 sum배열에 저장하는 식으로
// 해결함. ( sum[현재 집][ 칠할 색깔] 에 그 전 집의 색을 고려해서 최솟 값을 저장함.
package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S1_1149 {
    private static int[][] cost;
    private static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        cost = new int[N+1][3];
        sum = new int[N+1][3];
        for(int i = 1 ; i < N+1 ;i++)
            for(int j = 0 ; j < 3 ; j++)
                sum[i][j] = Integer.MAX_VALUE;

        for(int i =1 ; i <=N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(String.valueOf(findMinValue(N)));
        bw.flush();
    }
    public static int findMinValue(int N){
        int min_value = Integer.MAX_VALUE;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 0 ; j < 3 ; j++) {
                for(int k = 0 ; k < 3 ; k++) {
                    if (j == k)
                        continue;
                    if (sum[i][k] > sum[i - 1][j] + cost[i][k]) {
                        sum[i][k] = sum[i-1][j] + cost[i][k];
                    }
                }
            }
        }
        for(int i = 0 ; i <3 ; i++)
            if(min_value > sum[N][i])
                min_value = sum[N][i];
            return min_value;
    }
}
