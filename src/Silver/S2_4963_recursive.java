package Silver;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class S2_4963_recursive {
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

    private static boolean[][] visited;
    private static int[][] map;
    private static int[][] startLandNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        while (w != 0) {
            map = new int[h][w];
            startLandNumbers = new int[h][w];

            List<Info> landList = new ArrayList<>();

            /* 입력 처리 */
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == LAND){
                        // start land number는 맨 왼쪽 위부터 오른쪽으로
                        // 0 1 2 3 4
                        // 5 6 7 8 9 ... 이런 식입니다
                        landList.add(new Info(i, j));
                        startLandNumbers[i][j] = w * i + 1 * (j+1);
                    }
                }
            }

            /* 로직. */
            // start land number를 처음 시작한 섬 번호로 바꿔서 set에 삽입
            // set은 섬 개수를 세기 위함.
            visited = new boolean[h][w];

            Set<Integer> landNumberSet = new HashSet<>();

            for (Info info : landList) {
                recursive(info.row,info.col,landNumberSet);
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

    private static void recursive(int row ,int col,Set<Integer> landNumberSet){

        if(visited[row][col]){
            return;
        }

        landNumberSet.add(startLandNumbers[row][col]);
        visited[row][col] = true;

        for (int i = 0; i < ROW_DIR.length; i++) {
            int nextRow = row + ROW_DIR[i];
            int nextCol = col + COL_DIR[i];
            if(isOutOfRange(nextRow, map.length, nextCol, map[0].length)){
                continue;
            }

            if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == LAND){
                startLandNumbers[nextRow][nextCol]= startLandNumbers[row][col];
                recursive(nextRow,nextCol,landNumberSet);
            }
        }
    }
    private static boolean isOutOfRange(int nextRow, int h, int nextCol, int w) {
        return nextRow < 0 || nextRow >= h || nextCol < 0 || nextCol >= w;
    }
}
