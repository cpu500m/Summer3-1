package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G3_2638
 * @date : 2024-08-31
 */
public class G3_2638 {

    /* 방향 */
    private static final int[] ROW_DIR = {-1, 1, 0, 0};
    private static final int[] COL_DIR = {0, 0, -1, 1};

    private static final int EMPTY = 0;
    private static final int CHEESE = 1;

    static class Position {

        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static int[][] paper;
    private static Queue<Position> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* 우선은 내-외부 여부를 먼저 식별해줌 */
        // 내부인가
        boolean[][] isOutside = new boolean[n][m];

        queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        isOutside[0][0] = true;
        // 가장자리는 무조건 외부이므로 가장자리부터 BFS 때려서 싹다 외부임을 식별.
        doBfs(isOutside);

        int time = -1;
        // 아마 아래의 반복이 되지 않을까 싶음..

        boolean isFirst = true;
        while (isFirst) {
            time++;
            isFirst = false;
            // 이번 시간에 쓸 외부 여부
            boolean[][] isOutsideInThisTime = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    isOutsideInThisTime[i][j] = isOutside[i][j];
                }
            }
            int[][] nextPaper = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nextPaper[i][j] = paper[i][j];
                }
            }

            // 녹을 치즈 탐색해서 로직수행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (paper[i][j] == EMPTY) {
                        continue;
                    }

                    int contactNumber = 0;
                    for (int k = 0; k < 4; k++) {
                        if (isOutside[i + ROW_DIR[k]][j + COL_DIR[k]]) {
                            contactNumber++;
                        }
                    }
                    if (contactNumber > 1) { // 녹을애라면 녹이고 BFS 때려야함
                        // 녹은 걸로 처리
                        nextPaper[i][j] = EMPTY;
                        // BFS로 외부 여부를 갱신
                        queue.add(new Position(i, j));
                        isOutsideInThisTime[i][j] = true;
                        doBfs(isOutsideInThisTime);
                        isFirst = true;
                    }
                }
            }
            isOutside = isOutsideInThisTime;
            paper = nextPaper;
        }

        bw.write(String.valueOf(time));
        bw.flush();
    }

    private static void doBfs(boolean[][] isOutside) {

        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            int curRow = cur.row;
            int curCol = cur.col;
            for (int k = 0; k < 4; k++) {
                int nextRow = curRow + ROW_DIR[k];
                int nextCol = curCol + COL_DIR[k];
                if (isOutOfRange(nextRow,  nextCol)) {
                    continue;
                }
                // isOutside로 방문여부 따짐
                if (paper[nextRow][nextCol] == EMPTY && !isOutside[nextRow][nextCol]) {
                    queue.add(new Position(nextRow, nextCol));
                    isOutside[nextRow][nextCol]= true;
                }
            }
        }
    }

    private static boolean isOutOfRange(int nextRow, int nextCol) {
        return nextRow < 0 || nextRow > paper.length - 1 || nextCol < 0 || nextCol > paper[0].length - 1;
    }
}
