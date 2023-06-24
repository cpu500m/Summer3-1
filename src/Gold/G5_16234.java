package Gold;

import java.io.*;
import java.util.*;

public class G5_16234 {
    static class Position{
        int x, y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] row_dir = {-1, 1, 0, 0};
    static int[] col_dir = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 클래스 만들면 깔끔한데 뭐 저장정보 많이 없으니깐..
        int[][] arr = new int[N][N];
        int[][] team = new int[N][N];


        /*  입력  처리  */
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*  변화가 없을때까지 반복    */
        boolean is_changed = true;
        int cnt = 0;
        int marker;
        boolean[][] visited = new boolean[N][N];

        // BFS 할거임
        Queue<Position> queue = new LinkedList<>();

        // 변화가 있을 때 까지 반복.
        while (is_changed) {
            // 변화 여부 초기화
            is_changed = false;
            marker = 0;
            // 연합 및 방문 여부 초기화
            for (int a = 0; a < N; a++) {
                Arrays.fill(team[a], 0);
                Arrays.fill(visited[a], false);
            }

            // 연합 총 인구수 및 속한 나라
            int[] person_cnt = new int[N*N];
            int[] country_cnt = new int[N*N];

            // BFS
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문을 안한 나라의 경우에만 탐색.
                    if(visited[i][j] == false){
                        queue.add(new Position(i, j));
                        visited[i][j] = true;

                        while (!queue.isEmpty()) {
                            int pre_marker = marker;
                            Position cur = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int next_x = cur.x + row_dir[k];
                                int next_y = cur.y + col_dir[k];
                                if(next_x < 0 || next_x > N-1)
                                    continue;
                                else if(next_y < 0 || next_y > N-1)
                                    continue;

                                int diff = Math.abs(arr[cur.x][cur.y] - arr[next_x][next_y]);
                                if(visited[next_x][next_y] == false && L <= diff && diff <= R){

                                    if(pre_marker == marker && team[cur.x][cur.y] == 0){
                                        team[cur.x][cur.y] = ++marker;
                                        person_cnt[marker] = arr[cur.x][cur.y];
                                        country_cnt[marker] = 1;
                                        is_changed = true;
                                    }
                                    // 연합 맺고 방문여부 체크
                                    team[next_x][next_y] = team[cur.x][cur.y];
                                    person_cnt[team[next_x][next_y]] += arr[next_x][next_y];
                                    country_cnt[team[next_x][next_y]] += 1;
                                    visited[next_x][next_y] = true;
                                    queue.add(new Position(next_x, next_y));
                                }
                            }
                        }
                    }

                }
            }

            // 인구수 분배.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(team[i][j] != 0)
                        arr[i][j] = person_cnt[team[i][j]]/country_cnt[team[i][j]];
                }
            }


            // 변화가 있었다면 일수 증가
            if(is_changed) cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
