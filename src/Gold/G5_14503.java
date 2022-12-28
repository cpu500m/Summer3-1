// 좌표 r,c 라길래 컴퓨터 상의 좌표 표현인줄 알았는데
// 문제는 배열에서의 표현을 말하는거여서 7시간날림 ,,,;;
package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G5_14503 {
    // of array
    final static int WALL = 1;
    // direction
    final static int NORTH = 3;
    final static int EAST = 2;
    final static int SOUTH = 1;
    final static int WEST = 0;

    // for robot
    static int x,y,direction;
    static int result, cnt;

    // arr은 벽 or 빈 칸인지 여부를,  check는 청소 헀는지 여부를 나타냄.
    static int[][] arr;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int i, j ;
        boolean flag = false;
        result = 0;
        cnt = 0;

        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken())+1;
        x = Integer.parseInt(st.nextToken())+1;
        // 모듈러 형태로 수행하려고 바꿈
        direction = Integer.parseInt(st.nextToken());
        if(direction == 0)
            direction = NORTH;
        else if(direction == 1)
            direction = EAST;
        else if(direction == 2)
            direction = SOUTH;
        else if(direction == 3)
            direction = WEST;


        arr = new int[n+2][m+2];
        check = new boolean[n+2][m+2];

        // 외부를 벽으로 둘러싸고시작.
        for(i = 0 ; i <= n+1; i++)
            for(j= 0 ; j<= m+1; j++)
                arr[i][j] = WALL;

        for(i = 1 ; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(j = 1 ; j <= m ; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
//        for(i = 0 ; i <= n+1 ; i++){
//            for(j = 0 ; j <= m+1; j++)
//                bw.write(arr[i][j]+" ");
//            bw.write("\n");
//        }
        // 1~4 조건에 맞게 수행 ㄱㄱ
        while(true){

            // 1번
            if(!check[y][x] && arr[y][x] != WALL) {
                check[y][x] = true;
                // debug1!!!!!
//                bw.write(x+" "+y+"\n");
                result++;
            }

            // 2-1 ( true면 1번으로) && 2-2 4번반복 ( 원래 방향 돌아올때까지)
            while(true) {
                cnt = 0;
                while (cnt < 4) {
                    // 0->1 : N 1->2 : W  2->3 S 3->4 E
                    if (two_one()) {
                        cnt = 0;
                        break;
                    }
                    else
                        direction = (direction+1)%4;
                }
                if (cnt == 0)
                    break;
                if (!back())
                    flag = true;
                break;
            }
            if(flag)
                break;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static boolean two_one(){
        int left = (direction + 1) % 4;
        cnt++;
        if(left == NORTH && arr[y-1][x] != WALL && check[y-1][x] == false) {
            y = y - 1;
            direction = left;
        }

        else if(left == WEST && arr[y][x-1] != WALL && check[y][x-1] == false) {
            x = x - 1;
            direction = left;
        }

        else if(left == SOUTH &&arr[y+1][x] != WALL && check[y+1][x] == false ) {
            y = y + 1;
            direction = left;
        }

        else if(left == EAST &&arr[y][x+1] != WALL && check[y][x+1] == false) {
            x = x + 1;
            direction = left;
        }
        else return false;
        return true;
    }
    static boolean back(){
        if(direction == NORTH && arr[y+1][x] != WALL)
            y= y+1;
        else if(direction == WEST &&arr[y][x+1] != WALL)
            x = x+1;
        else if(direction == SOUTH&& arr[y-1][x] != WALL)
            y = y-1;
        else if(direction == EAST && arr[y][x-1] != WALL)
            x = x-1;
        else return false;
        return true;
    }
}
