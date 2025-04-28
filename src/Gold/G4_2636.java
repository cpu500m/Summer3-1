package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G4_2636
 * @date : 25. 4. 27.
 */
public class G4_2636 {

    private static final int[] ROW_DIR = {-1,1,0,0};
    private static final int[] COL_DIR = {0,0,-1,1};

    private static class Info{
        boolean isVisited;  // 방문했는지 여부
        boolean isOutSide; // 외부 공기인지 여부
        boolean isCheese;
        int row;
        int col;

        Info(int row , int col ,String identifier){
            this.row = row;
            this.col = col;
            isVisited = false;
            isOutSide = false;
            isCheese = identifier.equals("0") ? false : true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 1. 입력처리 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int cheeseCount = 0;

        Info[][] info = new Info[height][width];

        for(int i = 0 ; i < height ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < width ; j++){
                String mark = st.nextToken();
                info[i][j] = new Info(i,j, mark);
                if(mark.equals("1")){
                    cheeseCount++;
                }
            }
        }

        /* 2. 로직  */
        // 1 . 맨 바깥쪽을 기준으로 외부 공기를 식별한다. + 이번 턴에 녹을 치즈들은 list에 넣어 놓는다.
        // 녹는데 소요된 시간
        int time = 0;
        // 이전 시간에 남아있는 치즈 갯수
        int preCheeseCount = 0;
        Queue<Info> queue = new LinkedList<>();
        // 이번 턴에 녹을 치즈들을 넣어둘 리스트
        List<Info> meltedCheeseList = new LinkedList<>();
        // 첫 루프는 최외각를 바탕으로 외부 공기를 식별
        queue.add(info[0][0]);
        info[0][0].isVisited = true;
        info[0][0].isOutSide = true;

        while (cheeseCount > 0 ) {
            time++;
            preCheeseCount = cheeseCount;

            while (!queue.isEmpty()) {
                Info curInfo = queue.poll();
                int curRow = curInfo.row;
                int curCol = curInfo.col;
                for (int i = 0; i < 4; i++) {
                    int nextRow = curRow + ROW_DIR[i];
                    int nextCol = curCol + COL_DIR[i];

                    // 범위 밖이라면 건너 뜀
                    if (nextRow < 0 || nextRow >= height || nextCol < 0 || nextCol >= width) {
                        continue;
                    }

                    // 공기면서 방문하지않았다면 큐에 삽입
                    if (!info[nextRow][nextCol].isCheese && !info[nextRow][nextCol].isVisited) {
                        queue.add(info[nextRow][nextCol]);
                        info[nextRow][nextCol].isVisited = true;
                        info[nextRow][nextCol].isOutSide = true;
                    } else if (!info[nextRow][nextCol].isVisited
                            && info[nextRow][nextCol].isCheese) { // 방문하지 않은 치즈 (이번턴에 녹을 애)
                        info[nextRow][nextCol].isVisited = true;
                        meltedCheeseList.add(info[nextRow][nextCol]);
                    }
                }
            }

            // 이번턴에 녹을 치즈들을 녹인다
            for (Info i : meltedCheeseList) {
                i.isCheese = false;
                i.isOutSide = true;
                cheeseCount--;
                queue.add(i);
            }
            // 다 녹이고 리스트 비움
            meltedCheeseList.clear();
        }

        // 출력해야 할것 : time , preCheeseCount
        bw.write(time + "\n" + preCheeseCount);
        bw.flush();
    }
}
