package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos_2468{
    int x,y;
    Pos_2468(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class S1_2468 {
    static int[][] arr;
//    static boolean[][] flooding;
    static int[][] label;
    static boolean[][] visit;
    static Queue<Pos_2468> queue;
    // North -> East -> South -> West
    static int[] x_dir = {0,1,0,-1};
    static int[] y_dir = {-1,0,1,0};
    static int N;

    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int i,j;
        StringTokenizer st;
        arr = new int[N+2][N+2];
        label = new int[N+2][N+2];
//        flooding = new boolean[N+2][N+2];
        visit = new boolean[N+2][N+2];
        queue = new LinkedList<>();
        for(i = 0; i <N+2 ; i++)
            Arrays.fill(arr[i], 1);
        for(i = 1 ; i <= N; i++){
            st =new StringTokenizer(br.readLine());
            for(j = 1; j<=N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        bfs();
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static void bfs(){
        int x,y;
        int i,j,k,w,cur_x,cur_y;
        int label_num;
        Pos_2468 pos;

        for(i = 1 ; i <= 100; i++) {
            label_num = 0;
            for( j =1 ; j<=N ;j++)
                Arrays.fill(visit[j],false);
            for (j = 1; j <= N; j++) {
                for (k = 1; k <= N; k++) {
                    if (arr[j][k] <= i || visit[j][k] ==true)
                        continue;
                    else {
                        visit[j][k] = true;
                        queue.add(new Pos_2468(j,k));
                        label[j][k] = ++label_num;
                        if(result < label_num)
                            result = label_num;
                    }
                    while (!queue.isEmpty()) {
                        pos = queue.poll();
                        x = pos.x;
                        y = pos.y;
                        for (w = 0; w < 4; w++) {
                            cur_x = x + x_dir[w];
                            cur_y = y + y_dir[w];
                            if (arr[cur_x][cur_y] > i && visit[cur_x][cur_y] == false) {
                                visit[cur_x][cur_y] = true;
                                label[cur_x][cur_y] = label_num;
                                queue.add(new Pos_2468(cur_x, cur_y));
                            }
                        }
                    }
                }
            }
        }
    }
}
