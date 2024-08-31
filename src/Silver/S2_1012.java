package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S2_1012
 * @date : 2024-08-29
 */
public class S2_1012 {

    /* 입력 관련 상수 */
    private static final int ROW = 0;
    private static final int COL = 1;
    private static final int CABBAGE_COUNT = 2;

    /* 배추 심었는지 */
    private static final int PLANTED = 1;

    private static final int[] ROW_DIR={-1,1,0,0};
    private static final int[] COL_DIR={0,0,1,-1};

    // 큐에 넣을 위치 정보
    static class Position{
        private int row;
        private int col;

        Position(int row, int col){
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        final int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            // 입력 처리
            int[][] field = initField(br);

            // 로직 처리
            int earthwormCount = computeEarthwormCount(field);

            // 결괏값 StringBuilder 에 써줌
            sb.append(earthwormCount).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private static int[][] initField(BufferedReader br) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] field = new int[input[ROW]][input[COL]];

        for (int i = 0; i < input[CABBAGE_COUNT]; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            field[line[ROW]][line[COL]] = PLANTED;
        }
        return field;
    }

    private static int computeEarthwormCount(int[][] field) {
        int earthwormCount = 0;
        boolean[][] visited = new boolean[field.length][field[ROW].length];

        Queue<Position> positionQueue = new LinkedList<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[ROW].length; j++) {

                // 배추를 심은 곳이 아니라면 고려 대상 X
                if(field[i][j] != PLANTED){
                    continue;
                }

                positionQueue.add(new Position(i, j));
                boolean isFirst = false;

                while (!positionQueue.isEmpty()) {
                    Position currentPosition = positionQueue.poll();

                    int currentRow = currentPosition.getRow();
                    int currentCol = currentPosition.getCol();

                    // 방문했던 곳이라면 건너뛴다
                    if(visited[currentRow][currentCol]){
                        continue;
                    }

                    // 방문 처리
                    visited[currentRow][currentCol] = true;

                    // 한 곳이라도 방문했다면 첫 방문 여부 true
                    isFirst = true;

                    for (int k = 0; k < 4; k++) {
                        int nextRow = currentRow + ROW_DIR[k];
                        int nextCol = currentCol + COL_DIR[k];

                        // 범위 밖인가
                        if(isOutOfRange(nextRow, field, nextCol)){
                            continue;
                        }

                        // 방문가능한가
                        if(isVisitable(field, nextRow, nextCol, visited)){
                            positionQueue.add(new Position(nextRow, nextCol));
                        }
                    }
                }
                earthwormCount = isFirst ? earthwormCount + 1 : earthwormCount;
            }
        }
        return earthwormCount;
    }

    private static boolean isOutOfRange(int nextRow, int[][] field, int nextCol) {
        return nextRow < 0 || nextRow > field.length - 1 || nextCol < 0
                || nextCol > field[nextRow].length - 1;
    }

    private static boolean isVisitable(int[][] field, int nextRow, int nextCol,
            boolean[][] visited) {
        return field[nextRow][nextCol] == PLANTED && !visited[nextRow][nextCol];
    }
}
