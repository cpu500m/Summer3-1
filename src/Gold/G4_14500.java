// 최악의 경우 총 칸수 25,000
// 각각에 대해 4칸 탐색을 해서 최댓값을 기혹해 놓는 식으로 하면 시간 충분하다
// 근데 해보니간 백트래킹은 그냥 계속 진행하면서 경로를 쌓는식이다보니깐
// 이문제는 이전 길에서 진행하는 경로도 고려해야하는 문제인데..
// 하 ,, 앞으로는 생각을 더 하고 들어가자.. 오랜만이라 잊었다..

package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G4_14500 {
    static int[] row_dir = {-1, 1, 0, 0};
    static int[] col_dir = {0, 0, -1, 1};

    static int opt_val;

    static int[][] arr;
    static int N , M;
    static int[] r_arr;
    static int[] c_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*  입력 처리    */
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        opt_val = 0;

        /*   로직   */
        // 중복 루트를 제거하기 위함인데.. 그냥 뭐 생각나는대로 ~ 해봤음~ 빠르게~
        r_arr = new int[4];
        c_arr = new int[4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                r_arr[0] = i;
                c_arr[0] = j;
                backTracking(i , j, arr[i][j], 1);
            }
        }
        bw.write(String.valueOf(opt_val));
        bw.flush();
    }

    static void backTracking(int row , int col, int cum_val, int cnt){
        // 네 칸 다 검사했을 때
        if(check(cnt,cum_val))
            return ;


        for (int i = 0; i < 4; i++) {
            int r = row + row_dir[i];
            int c = col + col_dir[i];
            // 해당 경로가 유망하다면
            if(promising(r,c, cnt)){
                r_arr[cnt] = r;
                c_arr[cnt] = c;
                // 1 .. ~ n 번째 에서 출발한 경로를 모두 돌려본다.
                for (int j = 0; j < cnt+1; j++) {
                    backTracking(r_arr[j],c_arr[j],cum_val+arr[r][c],cnt+1);
                }
            }
        }
    }

    // 더하는 값이 유망한지 검사.
    static boolean promising(int row , int col , int cnt) {
        // 범위 밖인지 체크.
        if(row < 0 || row >= N || col < 0 || col >= M)
            return false;

        // 방문 했는지 체크
        for (int i = 0; i < cnt; i++) {
            if(r_arr[i] == row && c_arr[i] == col)
                return false;
        }
        return true;
    }

    static boolean check(int cnt , int cum_val){
        if(cnt == 4){
            if(opt_val < cum_val)
                opt_val = cum_val;
            return true;
        }
        return false;
    }
}
