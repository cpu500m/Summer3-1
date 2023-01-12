package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2_11780 {
    static int n;
    static int[][] graph;
    static int[][] dp;
    static int[][] path;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        /*      입력 처리       */
        n =Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        int v1, v2 , cost;

        graph = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        path = new int[n+1][n+1];
        // index
        int i, j;

        // 그래프 간선들 연견안된건 .. 일단 최대값보다 하나더 큰값으로 초기화.
        // 일단 초기 path도 0으로 초기화하자
        for(i = 0 ; i < n+1 ; i++) {
            Arrays.fill(graph[i], 10_000_001);
            Arrays.fill(path[i] , 0);
        }

        for(i = 0 ; i< bus ; i++){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            if(graph[v1][v2] > cost)
                graph[v1][v2] = cost;
        }

        // dp 배열 초기 상태는 graph로.
        for(i = 0 ; i <n +1 ; i++)
            for( j = 0 ; j < n +1 ; j++)
                dp[i][j] = graph[i][j];

        floyd();

        for(i = 1 ; i <= n ; i++){
            for(j=1 ; j <= n ; j++) {
                if(i== j)
                    dp[i][j] =0;
                else if(dp[i][j] == 10_000_001)
                    dp[i][j] = 0;
                bw.write(String.valueOf(dp[i][j] + " "));
            }
            bw.write("\n");
        }

        for( i =1 ; i <= n ; i++){
            for(j =1 ; j <= n ; j++) {
                cnt = 2;
                if(dp[i][j] == 0)
                    bw.write("0\n");
                else {
                    print_path(i, j);
                    bw.write(cnt+" "+i+" ");
                    bw.write(sb.toString());
                    bw.write(j+"\n");
                }
                sb.setLength(0);
            }
        }
        bw.flush();
    }
    static void floyd(){

        // index
        int i , j , k;
        for(k = 1 ; k <= n ; k++)
            for( i = 1; i <= n ; i++)
                for(j = 1; j<= n ; j++) {
                    if(i == j)
                        continue;
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        // k라는 경로를 지나간다는걸 표시해놓음.. 그니깐
                        // k는 계속 고쳐지겠지 해서
                        // 가장 큰 도시 번호가 저장되겟지.
                        // 그러면 이제 역추적할때..
                        // path[i][k] 보고 .. 하다가 path가 0인 지점을 만나면 그때 출력한번하고.
                        // 그리고 k에서 j까지도 같은 원리로 하면 되겠다.
                        path[i][j] = k;
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
    }

    static void print_path(int start , int end){
        int k = path[start][end];
        if(k == 0)
            return;
        print_path(start,k);
        sb.append(k+" ");
        cnt++;
        print_path(k,end);
    }
}
