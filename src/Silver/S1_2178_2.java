// bfs를 이용해서 알고리즘을 개선해보기로 함.
package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos_2178{
    int x;
    int y;
    Pos_2178(int x, int y){
        this.x =x;
        this.y =y;
    }
}
public class S1_2178_2 {
    final static int WALL = 0;
    static boolean[][] visit;
    static int[][] arr;
    static int[][] distance;
    static Queue<Pos_2178> queue;
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
        distance = new int[n+2][m+2];
        queue = new LinkedList<>();

        for (i = 0; i < n + 2; i++)
            Arrays.fill(arr[i], 0);
        for (i = 1; i <= n; i++) {
            line = br.readLine();
            for (j = 1; j <= m; j++)
                arr[i][j] = Character.getNumericValue(line.charAt(j - 1));
        }
        // 여기서부터 로직부분
        bfs(1, 1);
        bw.write(String.valueOf(distance[n][m]));
        bw.flush();
    }

    static void bfs(int x, int y) {
        int i, j;
        Pos_2178 pos;

        visit[y][x] = true;
        distance[y][x] = 1;

        queue.add(new Pos_2178(x,y));


        while (!queue.isEmpty()) {
            pos = queue.poll();
            x = pos.x;
            y = pos.y;
            for (i = -1; i <= 1; i++)
                for (j = -1; j <= 1; j++) {
                    if (Math.abs(i) == Math.abs(j))
                        continue;
                    if (arr[y + i][x + j] != WALL && visit[y + i][x + j] == false) {
                        visit[y+i][x+j] = true;
                        distance[y+i][x+j] = distance[y][x]+1;
                        queue.add(new Pos_2178(x+j,y+i));
                    }
                }
        }
    }
}
