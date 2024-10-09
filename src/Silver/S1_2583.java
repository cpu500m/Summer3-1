package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : S1_2583
 * @date : 2024-10-09
 */
public class S1_2583 {

    private static int[] ROW_DIR = {-1,0,0,1};
    private static int[] COL_DIR = {0,-1,1,0};

    private static int M;
    private static int N;


    private static class Position{
        int row;
        int col;
        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] isChecked = new boolean[M][N];

        /* 1. 입력 처리 */
        // 사각형 영역 내부임을 체크
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            for (int j = startX; j < endX; j++) {
                for (int k = startY; k < endY; k++) {
                    isChecked[k][j] = true;
                }
            }
        }

        /* 2. BFS 돌리기 */
        int count = 0;
        // 정렬을 위해 list 사용
        List<Integer> areaList = new ArrayList<>();

        Queue<Position> queue = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!isChecked[i][j]){
                    int area = 1;
                    count++;
                    queue.add(new Position(i, j));
                    isChecked[i][j] = true;

                    while(!queue.isEmpty()){
                        Position pos = queue.poll();
                        int curRow = pos.row;
                        int curCol = pos.col;
                        for (int k = 0; k < 4; k++) {
                            int nextRow = curRow + ROW_DIR[k];
                            int nextCol = curCol + COL_DIR[k];

                            if(!isOutOfBound(nextRow,nextCol) && !isChecked[nextRow][nextCol]){
                                isChecked[nextRow][nextCol] = true;
                                area++;
                                queue.add(new Position(nextRow, nextCol));
                            }
                        }
                    }

                    areaList.add(area);
                }
            }
        }

        /* 3. 출력 */
        // 오름차순 정렬
        areaList.sort(Integer::compareTo);

        StringBuilder areaSizeBuilder = new StringBuilder();
        areaList.forEach(area -> areaSizeBuilder.append(area).append(" "));

        bw.write(count +"\n" + areaSizeBuilder);

        bw.flush();
    }
    private static boolean isOutOfBound(int row , int col){
        return ( row < 0 || row >= M || col < 0 || col >= N );
    }
}
