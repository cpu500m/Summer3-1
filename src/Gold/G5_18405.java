package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_18405
 * @date : 2024-09-05
 */
public class G5_18405 {

    static class Virus{
        int row;
        int col;
        int kind;
        int time;
        public Virus(int row, int col,int kind, int time){
            this.row = row;
            this.col = col;
            this.kind = kind;
            this.time = time;
        }
    }
    private static final int EMPTY = 0;
    private static final int[] ROW_DIR = {-1,1,0,0};
    private static final int[] COL_DIR = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 입력 처리 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        
        // 1. 시간
        // 2. 종류
        PriorityQueue<Virus> queue = new PriorityQueue<>((v1,v2) ->{
            if (v1.time == v2.time) {
                return v1.kind - v2.kind;
            }
            return v1.time - v2.time;
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 바이러스라면 큐에 삽입
                if(map[i][j] != EMPTY){
                    queue.add(new Virus(i, j,map[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;

        // 로직
        bfs(queue, s, map);

        bw.write(String.valueOf(map[x][y]));
        bw.flush();
    }

    private static void bfs(PriorityQueue<Virus> queue, int s, int[][] map) {
        int n = map.length;
        while(!queue.isEmpty()){
            Virus cur = queue.poll();
            int kind = cur.kind;
            if(cur.time == s){
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + ROW_DIR[i];
                int nextCol = cur.col + COL_DIR[i];
                if(isOutOfRange(nextRow, n, nextCol)){
                    continue;
                }
                if (map[nextRow][nextCol] == EMPTY) {
                    map[nextRow][nextCol] = kind;
                    queue.add(new Virus(nextRow,nextCol,kind,cur.time+1));
                }
            }
        }
    }

    private static boolean isOutOfRange(int nextRow, int n, int nextCol) {
        return nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n;
    }
}
