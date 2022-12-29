package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pos_2667{
    int x,y;
    Pos_2667(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class S1_2667 {
    final static int WALL = 0;
    static int[][] map;
    static boolean[][] visit;
    static int[][] label;
    static Queue<Pos_2667> queue;
    static int cnt , label_num, n;

    // North -> East -> South -> West
    static int[] x_dir = {0,1,0,-1};
    static int[] y_dir = {-1,0,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int i,j;
        map = new int[n+2][n+2];
        visit = new boolean[n+2][n+2];
        label  = new int[n+2][n+2];
        queue = new LinkedList<>();
        String line;
        cnt = 0;
        label_num = 0;
        // 벽으로 둘러싸고 시작
        for(i = 0; i < n+2; i++)
            Arrays.fill(map[i],0);

        for (i = 1; i <= n; i++) {
            line = br.readLine();
            for (j = 1; j <= n; j++)
                map[i][j] = Character.getNumericValue(line.charAt(j - 1));
        }
        bfs();

        Integer[] count = new Integer[cnt+1];
        Arrays.fill(count,0);

        bw.write(String.valueOf(cnt)+"\n");

        for(i = 1; i <=n; i++)
            for(j=1 ; j<= n; j++) {
                if(label[i][j] == 0)
                    continue;
                count[label[i][j]]++;
            }
        Arrays.sort(count);
        for(i = 1; i <= cnt ; i++)
            bw.write(count[i]+"\n");
        bw.flush();
    }
    static void bfs(){
        int x,y;
        int a,b,i ,cur_x,cur_y;
        Pos_2667 pos;

        for(a = 1 ; a <=n ; a++) {
            for (b = 1; b <= n; b++) {
                if(map[a][b] == WALL || visit[a][b])
                    continue;
                else {
                    visit[a][b] = true;
                    queue.add(new Pos_2667(b, a));
                    label[a][b] = ++label_num;
                    cnt++;
                }
                while (!queue.isEmpty()) {
                    pos = queue.poll();
                    x = pos.x;
                    y = pos.y;
                    for (i = 0; i < 4; i++) {
                        cur_x = x + x_dir[i];
                        cur_y = y + y_dir[i];
                        if (map[cur_y][cur_x] != WALL && visit[cur_y][cur_x] == false) {
                            visit[cur_y][cur_x] = true;
                            label[cur_y][cur_x] = label_num;
                            queue.add(new Pos_2667(cur_x, cur_y));
                        }
                    }
                }
            }
        }
    }
}
