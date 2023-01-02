// BFS... 여기까지 일단 ..
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos_2573{
    int x,y;
    Pos_2573(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class G4_2573{
    static int[] x_dir = {-1,1,0,0};
    static int[] y_dir = {0,0,-1,1};
    static int[][] iceberg;
    static boolean[][] visit;
    static Queue<Pos_2573> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인덱스
        int i,j,k, w;
        // 결과
        int result = 0;
        // 행,열 입력 처리 및 배열 생성
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] pre_iceberg = new int[n][m];
        iceberg = new int[n][m];

        // 배열 입력 처리
        for(i = 0 ; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(j = 0; j < m; j++)
                iceberg[i][j] = Integer.parseInt(st.nextToken());
        }

        // 로직 1번 수행을 위한 빙산의 이전 상태를 기록해놓는 배열생성
        for( i = 0 ; i < n ; i++)
            for(j = 0 ; j < m ; j++)
                pre_iceberg[i][j] = iceberg[i][j];
        // 로직
        for(i = 0; i <1000; i++){
            // 큐 초기화 귀찮으니 큐생성 . visit도
            queue = new LinkedList<>();
            visit = new boolean[n][m];

            // 1. 빙산이 몇개의 덩어리로 분리됐는지를 확인. true 반환시 2덩어리 이상. false 반환시 1덩어리 이하를 의미
            if(bfs()){
                result = i;
                break;
            }
            // 2. N년이 지난후 빙산 상태 기록
            for(j = 1; j < n-1; j++){
                for(k= 1; k < m-1 ; k++) {
                    if (pre_iceberg[j][k] != 0) {
                        for (w = 0; w < 4; w++) {
                            if (pre_iceberg[j + x_dir[w]][k + y_dir[w]] == 0)
                                iceberg[j][k]--;
                        }
                        if (iceberg[j][k] < 0)
                            iceberg[j][k] = 0;
                    }
                }
            }
            for( j = 0 ; j < n ; j++)
                for(k = 0 ; k < m ; k++)
                    pre_iceberg[j][k] = iceberg[j][k];

        }
        bw.write(String.valueOf(result));
        bw.flush();

    }
    static boolean bfs(){
        int i,j, k;
        int x,y, cur_x,cur_y;
        int cnt = 0;
        Pos_2573 pos;
        for(i = 1 ; i < iceberg.length-1; i++)
            for(j = 1 ; j < iceberg[i].length-1 ; j++){
                if(visit[i][j] == true || iceberg[i][j] == 0)
                    continue;
                else{
                    visit[i][j] =true;
                    queue.add(new Pos_2573(i,j));
                    cnt++;
                    if(cnt > 1)
                        return true;
                }
                while (!queue.isEmpty()){
                    pos = queue.poll();
                    x = pos.x;
                    y = pos.y;
                    for(k = 0 ; k<4 ; k++){
                        cur_x = pos.x + x_dir[k];
                        cur_y = pos.y + y_dir[k];
                        if(iceberg[cur_x][cur_y] !=0 && visit[cur_x][cur_y] == false){
                            visit[cur_x][cur_y] = true;
                            queue.add(new Pos_2573(cur_x,cur_y));
                        }
                    }
                }
            }
        return false;
    }
}
