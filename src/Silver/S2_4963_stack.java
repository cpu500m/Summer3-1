package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S2_4963_stack
 * @date : 2024-09-13
 */
public class S2_4963_stack {

    static class Info{
        int row;
        int col;
        Info(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private static final int[] ROW_DIR = {-1,1,-1,1,0,0,1,-1};
    private static final int[] COL_DIR = {-1,1,1,-1,1,-1,0,0};

    private final static int OCEAN = 0;
    private final static int LAND = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        while (w != 0) {
            int[][] map = new int[h][w];
            int[][] startLandNumbers = new int[h][w];

            Stack<Info> stack = new Stack<Info>();

            /* 입력 처리 */
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == LAND){
                        // start land number는 맨 왼쪽 위부터 오른쪽으로
                        // 0 1 2 3 4
                        // 5 6 7 8 9 ... 이런 식입니다
                        stack.push(new Info(i, j));
                        startLandNumbers[i][j] = w * i + 1 * (j+1);
                    }
                }
            }

            /* 로직. */
            // start land number를 처음 시작한 섬 번호로 바꿔서 set에 삽입
            // set은 섬 개수를 세기 위함.
            boolean[][] visited = new boolean[h][w];

            Set<Integer> landNumberSet = new HashSet<Integer>();

            while(!stack.isEmpty()){
                Info cur = stack.pop();
                int curRow = cur.row;
                int curCol = cur.col;


                if(visited[curRow][curCol]){
                    continue;
                }
                visited[curRow][curCol] = true;

                landNumberSet.add(startLandNumbers[curRow][curCol]);

                for (int i = 0; i < ROW_DIR.length; i++) {
                    int nextRow = curRow + ROW_DIR[i];
                    int nextCol = curCol + COL_DIR[i];
                    if(isOutOfRange(nextRow, h, nextCol, w)){
                        continue;
                    }

                    if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == LAND){
                        stack.push(new Info(nextRow, nextCol));
                        startLandNumbers[nextRow][nextCol]= startLandNumbers[curRow][curCol];
                    }
                }
            }

            // Set을 이용해 섬 개수를 카운트한다.
            int landCount = landNumberSet.size();
            sb.append(landCount).append("\n");

            // 그 다음 케이스 입력 처리
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isOutOfRange(int nextRow, int h, int nextCol, int w) {
        return nextRow < 0 || nextRow >= h || nextCol < 0 || nextCol >= w;
    }
}