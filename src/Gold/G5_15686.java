package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_15686
 * @date : 2024-09-04
 */
public class G5_15686 {

    static class Position {
        int index;
        int row;
        int col;
        int distance;

        Position(int index,int x, int y) {
            this.index = index;
            this.row = x;
            this.col = y;
        }
    }

    private static final int EMPTY = 0;
    private static final int HOUSE = 1;
    private static final int CHICKEN = 2;

    private static int result = Integer.MAX_VALUE;
    private static int numToClose;
    private static int houseCount;
    private static int chickenCount;
    private static Position[][] houseToChickenMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 입력 처리 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map =new int[n][n];
        Map<Integer, Position> chickenMap = new HashMap<>();
        chickenCount = 0;
        houseCount = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 치킨집이면 기록
                if(map[i][j] == CHICKEN){
                    chickenMap.put(chickenCount, new Position(chickenCount++,i, j));
                } else if(map[i][j] == HOUSE){
                    houseCount++;
                }
            }
        }

        // 다시 루프를 돌리면서 집일경우 치킨집까지의 좌표를 계산한다
        // [house_index][chicken_index] 오름차순 sort
        houseToChickenMatrix = new Position[houseCount][chickenCount];
        int houseIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == HOUSE){
                    for(int k = 0; k < chickenMap.size(); k++) {
                        Position curChickenPos = chickenMap.get(k);
                        houseToChickenMatrix[houseIndex][k] = computeDistance(curChickenPos, i, j);
                    }
                    // 오름차순 정렬
                    Arrays.sort(houseToChickenMatrix[houseIndex],
                            Comparator.comparingInt(o -> o.distance));
                    houseIndex++;
                }
            }
        }

        // chickenCount - M개의 치킨집만 살리기
        numToClose = chickenCount - m;
        boolean[] visited = new boolean[chickenCount];
        logic(visited,0,0);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void logic(boolean[] visited,int curIndex,int len) {
        int curCloseCount = 0;

        // 없앨만큼 없앴다면 최적인지 따짐
        if(numToClose == len){
            int distanceSum = 0;
            for (int i = 0; i < houseCount; i++) {
                for(int j = 0; j < chickenCount; j++){
                    Position curPos = houseToChickenMatrix[i][j];
                    if(visited[curPos.index]) continue;
                    distanceSum += curPos.distance;
                    break;
                }
            }
            result = Math.min(result,distanceSum);
            return;
        }

        for (int i = curIndex; i < chickenCount; i++) {
            visited[i] = true;
            logic(visited,i+1,len+1);
            visited[i] = false;
        }
    }

    private static Position computeDistance(Position curChickenPos, int i, int j) {
        int distance = Math.abs(curChickenPos.row - i) + Math.abs(curChickenPos.col - j);
        Position position = new Position(curChickenPos.index, curChickenPos.row, curChickenPos.col);
        position.distance = distance;
        return position;
    }
}