package Silver;

import static java.nio.file.Files.newBufferedReader;

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
 * @fileName : S1_1926
 * @date : 2025-04-14
 */
public class S1_1926 {

    private static class Position {
        int row;
        int col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static final int[] ROW_DIR = {0, 0, -1, 1};
    private static final int[] COL_DIR = {1, -1, 0, 0};
    private static final short PICTURE = 1;
    private static final short VISITED = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        short[][] map = new short[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Short.parseShort(st.nextToken());
            }
        }

        int pictureCount = 0;
        int maxExtent = 0;

        Queue<Position> queue = new LinkedList<>();

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == PICTURE){
                    queue.add(new Position(i, j));
                    map[i][j] = VISITED;

                    int currentExtent = 0;
                    pictureCount++;

                    while(!queue.isEmpty()){
                        Position p = queue.poll();
                        int currentRow = p.row;
                        int currentCol = p.col;
                        currentExtent++;
                        for(int k = 0 ; k < 4 ; k++) {
                            int nextRow = currentRow + ROW_DIR[k];
                            int nextCol = currentCol + COL_DIR[k];
                            if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M){
                                continue;
                            }
                            if(map[nextRow][nextCol] == PICTURE){
                                map[nextRow][nextCol] = VISITED;
                                queue.add(new Position(nextRow, nextCol));
                            }
                        }
                    }
                    if(currentExtent > maxExtent){
                        maxExtent = currentExtent;
                    }
                }
            }
        }
        bw.write(pictureCount + "\n" + maxExtent);
        bw.flush();
    }
}
