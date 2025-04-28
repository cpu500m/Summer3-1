package pccp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author : paulkim
 * @description :
 * @packageName : pccp
 * @fileName : quest2_2
 * @date : 25. 4. 27.
 */
public class quest2_2 {

    static class Info {

        int extent;

        Info() {
            this.extent = 0;
        }
    }

    static class Position {

        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static final int[] ROW_DIR = {-1, 1, 0, 0};
    private static final int[] COL_DIR = {0, 0, 1, -1};

    private static final int OIL = 1;

    public static void main(String[] args) {
        int[][] array = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };

        System.out.println(solution(array));
    }

    public static int solution(int[][] land) {

        // 1. Set에 기록
        Map<Integer, Set<Info>> map = new HashMap<>();
        int width = land[0].length;
        // 노드 방문 여부
        boolean[][] isVisited = new boolean[land.length][land[0].length];

        for (int i = 0; i < width; i++) {
            map.put(i, new HashSet<Info>());
        }

        Queue<Position> queue = new LinkedList<>();

        // 석유 영역들을 저장해놓는다
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == OIL && !isVisited[i][j]) {
                    Info curInfo = new Info();

                    isVisited[i][j] = true;
                    queue.add(new Position(i, j));

                    while (!queue.isEmpty()) {
                        Position curPos = queue.poll();
                        curInfo.extent++;
                        int curRow = curPos.row;
                        int curCol = curPos.col;

                        map.get((long) curCol).add(curInfo);

                        for (int k = 0; k < 4; k++) {
                            int nextRow = curPos.row + ROW_DIR[k];
                            int nextCol = curPos.col + COL_DIR[k];

                            if (nextRow < 0 || nextRow >= land.length || nextCol < 0
                                    || nextCol >= land[0].length) {
                                continue;
                            }

                            if (!isVisited[nextRow][nextCol] && land[nextRow][nextCol] == OIL) {
                                queue.add(new Position(nextRow, nextCol));
                                isVisited[nextRow][nextCol] = true;
                            }
                        }
                    }
                }
            }
        }

        // 최대값을 구한다
        int maxValue = 0;

        for (int i = 0; i < width; i++) {
            Set<Info> curSet = map.get(i);
            int curValue = 0;

            for (Info curInfo : curSet) {
                curValue += curInfo.extent;
            }

            if (curValue > maxValue) {
                maxValue = curValue;
            }
        }
        return maxValue;
    }
}