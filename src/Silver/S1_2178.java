// 처음에 DFS를 이용해서 풀어보기로 결정
// 시간초과가 발생해서 뭐가 문제일까 생각해봄..
// 처음에 생각한 방식은 시간복잡도가 O(3^n)이라는걸 꺠달음.
// 그래서 다른 방식을 생각해본 결과 기록해놓으면서 진행하는 dp로 해결하기로 결정.
// 그러면 한번 기록해놓은곳은 스킵가능하니깐 좀더 개선될거라고 생각했음.
// 근데 해보니깐 통과는 되지만 여전히 좋지 못한 성능을 보여줌.
// 그래서 BFS를 이용한 방식으로 다시 풀어보기로 결정.

package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_2178 {
    final static int WALL = 0;
    static boolean[][] visit;
    static int[][] arr;
    // dp로 해결 ㄱ
    static int[][] dp;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int i, j;
        // 0, n+1 , m+1부분은 벽으로 처리
        visit = new boolean[n + 2][m + 2];
        String line;
        // 얘도 똑같음
        arr = new int[n + 2][m + 2];
        dp = new int[n + 2][m + 2];

        for (i = 0; i < n + 2; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        for (i = 0; i < n + 2; i++)
            Arrays.fill(arr[i], 0);
        for (i = 1; i <= n; i++) {
            line = br.readLine();
            for (j = 1; j <= m; j++)
                arr[i][j] = Character.getNumericValue(line.charAt(j - 1));
        }
        // 여기서부터 로직부분
        dynamic(1, 1, 1);
        bw.write(String.valueOf(dp[n][m]));
        bw.flush();
    }

    /* 두번째로 사용해본 방식 (다이나믹 프로그래밍) */
    static void dynamic(int x, int y, int count) {
        int i, j;
        if (dp[y][x] > count)
            dp[y][x] = count;
        else return;
        if (x == m && y == n)
            return;
        visit[y][x] = true;
        for (i = -1; i <= 1; i++)
            for (j = -1; j <= 1; j++) {
                if (Math.abs(i) == Math.abs(j))
                    continue;
                if (arr[y + i][x + j] != WALL && visit[y + i][x + j] == false) {
                    dynamic(x + j, y + i, count + 1);
                }
            }
        visit[y][x] = false;
    }
}
    /* 시간 초과난 알고리즘 */
//    static void dfs(int x,int y, int count){
//        int i ,j ;
//        if(x== m && y== n){
//            if(optimal_cnt > count )
//                optimal_cnt = count;
//            return ;
//        }
//        visit[y][x] = true;
//        for(i = -1; i<=1; i++)
//            for(j = -1; j<=1 ; j++){
//                if(Math.abs(i) == Math.abs(j))
//                    continue;
//                if(arr[y+i][x+j] != WALL && visit[y+i][x+j] == false){
//                    dfs(x+j,y+i, count+1);
//                }
//            }
//        visit[y][x] = false;
//    }
