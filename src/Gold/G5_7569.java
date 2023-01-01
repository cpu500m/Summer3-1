// 처음에 익은 토마토라면 큐에 넣고 시작하는 것이 핵심.
// 왜틀렸지 하다가 이생각을 30분만에함;
package Gold;


import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos_7569{
    int x,y,z;
    Pos_7569(int x, int y , int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class G5_7569 {
    static int[] dir_z = {0,0,0,0,1,-1};
    static int[] dir_x = {1,-1,0,0,0,0};
    static int[] dir_y = {0,0,1,-1,0,0};
    static int[][][] tomato;
    static int[][][] cnt;
    static Queue<Pos_7569> queue;
    static int m,n,h;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m =  Integer.parseInt(st.nextToken());
        n =  Integer.parseInt(st.nextToken());
        h =  Integer.parseInt(st.nextToken());
        tomato = new int[h+2][n+2][m+2];
        cnt = new int[h+2][n+2][m+2];
        queue = new LinkedList<>();
        int i , j ,k;

        // 빈칸으로 둘러쌈
        for(i = 0 ; i< h+2; i++)
            for(j= 0 ; j < n +2; j++) {
                Arrays.fill(tomato[i][j], -1);
                Arrays.fill(cnt[i][j], -1);
            }

        for(i = 1; i <= h ; i++)
            for(j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for (k = 1; k <= m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k] == 1) {
                        cnt[i][j][k] = 0;
                        queue.add(new Pos_7569(i,j,k));
                    }
                }
            }

         bfs();

        for(i = 1; i <= h ; i++)
            for(j = 1; j <= n; j++)
                for (k = 1; k <= m; k++) {
                    if(cnt[i][j][k] == -1 && tomato[i][j][k] == 0)
                        max = 1000001;
                    if (max < cnt[i][j][k])
                        max = cnt[i][j][k];
                }

        if(max == 1000001)
            bw.write("-1");
        else bw.write(String.valueOf(max));
        bw.flush();
    }
    static void bfs(){
        int i , j , k, a;
        int cur_x,cur_y,cur_z , x,y,z;
        Pos_7569 pos;
            for (i = 1; i <= h; i++)
                for (j = 1; j <= n; j++)
                    for (k = 1; k <= m; k++) {
                        if(tomato[i][j][k] !=  1)
                            continue;
                        else
                            queue.add(new Pos_7569(i,j,k));
                        while (!queue.isEmpty()) {
                            pos = queue.poll();
                            x = pos.x;
                            y = pos.y;
                            z = pos.z;
                            for (a = 0; a < 6; a++) {
                                cur_x = x + dir_x[a];
                                cur_y = y + dir_y[a];
                                cur_z = z + dir_z[a];
                                if (tomato[cur_x][cur_y][cur_z] == 0) {
                                    cnt[cur_x][cur_y][cur_z] = cnt[x][y][z] + 1;
                                    tomato[cur_x][cur_y][cur_z] = 1;
                                    queue.add(new Pos_7569(cur_x, cur_y, cur_z));
                                }
                            }
                        }
                    }
    }
}
