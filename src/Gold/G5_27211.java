package Gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_27211 {
    static class Pos{
        int x,y;
        Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    final static int BLOCK = 1;

    static int[] y_dir =  {-1,1,0,0};
    static int[] x_dir = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // index
        int i,j,k;

        /*      입력  처리      */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for( j =0  ; j < M ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        /*      로직      */
        boolean[][] visit = new boolean[N][M];
        Queue<Pos> queue = new LinkedList<>();
        int area = 0;
        int x,y,cur_x,cur_y;
        Pos cur_pos;

        for( j = 0 ; j < N ; j++){
            for(i = 0 ; i < M ; i++){
                if(visit[j][i] == false && map[j][i] != BLOCK) {
                    // 컴퓨터상의 좌표표현 사용
                    visit[j][i] = true;
                    queue.add(new Pos(j, i));
                    area++;
                }
                while (!queue.isEmpty()){
                    cur_pos = queue.poll();
                    x = cur_pos.x;
                    y = cur_pos.y;
                    for(k = 0 ; k< 4 ; k++){
                        cur_x = x+ x_dir[k];
                        // 걍 모둘려연산 사용말고 조건문 하나 사용해서 맵의 끝에서 끝으로 이동이 가능케함
                        if(cur_x < 0)
                            cur_x = M-1;
                        else if(cur_x > M-1)
                            cur_x = 0;
                        cur_y = y+y_dir[k];
                        if(cur_y < 0)
                            cur_y = N-1;
                        else if(cur_y > N-1)
                            cur_y = 0;

                        if(visit[cur_y][cur_x] == false && map[cur_y][cur_x] != BLOCK) {
                            visit[cur_y][cur_x] =true;
                            queue.add(new Pos(cur_y, cur_x));
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(area));
        bw.flush();

    }
}
