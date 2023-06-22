// 일단은.. 문제에서 2의 개수가 (바이러스 갯수가)
// 2<= 바이러스 <= 10 인게 포인트 인거 같음..
// 바이러스를 찾아서 그를 기준으로 탐색을 해나가야 할거 같은데... 좀더 생각해보자
// 아무리 생각해도 답이 안나옴 ;; 이건 너무어려운데? 라고 생각을하다가
// 그냥 영역 좁으니깐 벽설치하는 모든 경우의수대로 다해볼까? 라고 생각을했는데
// 그러면 최소 바이러스가 2개니깐 벽 설치 경우의 수가 62 C 3 니깐 약 40000가지.
// 40000가지의 각 경우의 수 마다 바이러스를 퍼트려보는 시뮬레이션을 해야하는데
// 이는 최악의 경우 8*8의 영역에서 탐색하는 경우니깐
// 64번의 루프에서 이것저것 조건문 따지면 한 5번의 연산 정도?
// 그러면 40000*64 * 5 떄리면 음 뭘 해도 넉넉한데? ;;
// 이렇게 풀자
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_14502 {

    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;

    static int[] row_dir = {-1, 1, 0, 0};
    static int[] col_dir = {0, 0, 1, -1};
    static class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*  입력 처리   */
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+2][M+2];
        int[][] arr_cp = new int[N+2][M+2];
        // 정답
        int opt_val = 0;
        // 토탈 칸수
        final int SUM = N * M;

        // 일단 다 벽으로 채움.
        for (int i = 0; i < N+2; i++)
        Arrays.fill(arr[i] ,1);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 벽 세우는 경우의 수에 대해 시뮬레이션.
        for (int i = 0; i < SUM-2 ; i++) {
            int r1 = (i/M) +1;
            int c1 = (i%M)+1;
            if(arr[r1][c1] != EMPTY)
                continue;
            for (int j = i+1; j < SUM-1; j++) {
                int r2= (j/M) +1;
                int c2= (j%M)+1;
                if(arr[r2][c2] != EMPTY)
                    continue;
                for (int k = j+1; k < SUM; k++) {
                    int r3= (k/M) +1;
                    int c3= (k%M)+1;
                    if(arr[r3][c3] != EMPTY)
                        continue;

                    // 셋다 빈 공간 이었다면 복사 뜨고 바이러스 퍼트려봄.
                    // deep_copy
                    for (int a = 0; a < N + 2; a++)
                        for (int b = 0; b < M + 2; b++) {
                            arr_cp[a][b] = arr[a][b];
                        }

                    arr_cp[r1][c1] = WALL;
                    arr_cp[r2][c2] = WALL;
                    arr_cp[r3][c3] = WALL;

                    boolean[][] visited = new boolean[N + 2][M + 2];
                    Queue<Position> queue = new LinkedList<>();
                    // 바이러스 퍼트림
                    for (int a = 1; a <= N; a++) {
                        for (int b = 1; b <= M; b++) {
                            // 방문하지 않은 곳이면서 바이러스면 큐에 삽입.
                            if(!visited[a][b] && arr_cp[a][b] == VIRUS) {
                                queue.add(new Position(a, b));
                                visited[a][b] = true;
                            }

                            while (!queue.isEmpty()) {
                                Position cur_pos = queue.poll();

                                // 상하 좌우 네방향 돌면서 퍼뜨림.
                                for (int d = 0; d < 4; d++) {
                                    if(arr_cp[cur_pos.row+row_dir[d]][cur_pos.col+col_dir[d]] == EMPTY){
                                        arr_cp[cur_pos.row + row_dir[d]][cur_pos.col + col_dir[d]] = VIRUS;
                                        queue.add(new Position(cur_pos.row + row_dir[d], cur_pos.col + col_dir[d]));
                                        visited[cur_pos.row + row_dir[d]][cur_pos.col + col_dir[d]] = true;
                                    }
                                }
                            }
                        }
                    }

                    // 안전공간 카운트
                    int cnt = 0;
                    for (int a = 1; a <= N ; a++)
                        for(int b = 1; b<= M ; b++)
                            if(arr_cp[a][b] == EMPTY) cnt++;

                    // 정답 갱신
                    if(cnt > opt_val)
                        opt_val = cnt;
                }
            }
        }
        bw.write(String.valueOf(opt_val));
        bw.flush();
    }
}
