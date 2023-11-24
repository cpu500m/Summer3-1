// 일단 1을 하나씩 0으로 만들어보는건
// 최악 O((NM)^2)일테니 당연히 안되고
// 최단거리 탐색문제니깐 DFS고
// 벽을 부수고 온경우와 안부수고 온경우 각각에 대해 갱신을 하면서 들어가야 할듯?
package Gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_2206 {
    static class Position{
        int row;
        int col;
        int val;
        boolean isBreak;

        public Position(int row, int col, int val,boolean isBreak) {
            this.row = row;
            this.col = col;
            this.val = val;
            this.isBreak = isBreak;
        }
    }

    private final static boolean WALL = false;
    private final static boolean EMPTY = true;
    private final static int NOT_BREAK = 0;
    private final static int BREAK = 1;
    private static int[] rowDir = {1,-1,0,0};
    private static int[] colDir = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 입력 처리
        // 벽이아니면 false 벽이면 true
        boolean[][] map = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                map[i][j] = (c == '1' ? WALL : EMPTY);
            }
        }

        // 로직 (DFS)
        int[][][] minLen = new int[n][m][2];

        logic(n, m, map, minLen);


        printResult(n, m, minLen);
    }

    private static void logic(int n, int m, boolean[][] map, int[][][] minLen) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(1, 1, 1,false));
        minLen[0][0][NOT_BREAK] =1;
        while (!queue.isEmpty()) {
            // 현재 방향 꺼냄.
            Position cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int curRow = cur.row + rowDir[i];
                int curCol = cur.col + colDir[i];
                // 범위 밖이면 스킵
                if (curRow < 1 || curRow > n || curCol < 1 || curCol > m) {
                    continue;
                }

                boolean curTile= map[curRow-1][curCol-1];
                // 벽을 부쉈는데 또 부숴야 하는 경우도 역시 스킵
                if(cur.isBreak == true && curTile == WALL) continue;

                // 그 외의 경우라면 고려 대상.
                // 근데이제 나눠서 봐야겠지
                if(curTile == WALL){
                    if(minLen[curRow-1][curCol-1][BREAK] == 0){
                        minLen[curRow-1][curCol-1][BREAK] = cur.val+1;
                        queue.add(new Position(curRow,curCol,cur.val+1,true));
                    }
                } else{
                    int cond = cur.isBreak ? BREAK : NOT_BREAK;
                    if(minLen[curRow-1][curCol-1][cond] == 0){
                        minLen[curRow-1][curCol-1][cond] = cur.val+1;
                        queue.add(new Position(curRow,curCol,cur.val+1,cur.isBreak));
                    }
                }
            }
        }
    }

    private static void printResult(int n, int m, int[][][] minLen) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(minLen[n -1][m -1][NOT_BREAK] == 0){
            if(minLen[n -1][m -1][BREAK] == 0) bw.write("-1");
            else bw.write(String.valueOf(minLen[n -1][m -1][BREAK]));
        }else if(minLen[n -1][m -1][BREAK] == 0){
            if(minLen[n -1][m -1][NOT_BREAK] == 0) bw.write("-1");
            else bw.write(String.valueOf(minLen[n -1][m -1][NOT_BREAK]));
        } else bw.write(minLen[n - 1][m - 1][NOT_BREAK] > minLen[n - 1][m - 1][BREAK] ?
                String.valueOf(minLen[n - 1][m - 1][BREAK])
                : String.valueOf(minLen[n - 1][m - 1][NOT_BREAK]));
        bw.flush();
    }
}
