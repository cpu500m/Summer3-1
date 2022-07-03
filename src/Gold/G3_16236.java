// 거리가 같다면 위 물고기를 먼저먹고, 그다음 왼쪽 물고기를 먹는다고 하였으니까
// 너비 우선 탐색을 하는데
// 위를 1순위, 왼쪽을 2순위 , 오른쪽을 3순위, 아래를 4순위로 탐색하면 될 것 같음.
// 일단 위 왼쪾 오른쪽 아래 한번 슥보고
// 먹을거 없으면 왼쪽으로 이동해서 또보고 하는 식으로 너비 우선탐색 하면 될듯.
// 너비 우선 탐색을 위해 큐를 써보기로 결정.
package Gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

class Shark{
    private int x;
    private int y;
    private int eaten_fish;
    private int size;
    Shark(){
        this.eaten_fish=0;
        this.size =2;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    public boolean compareSize(){
        if(this.eaten_fish == this.size)
            return true;
        else return false;
    }
}
public class G3_16236 {
    static int[][] space;
    static Queue<Vector<Integer>> queue;
    static Vector<Integer> position;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        queue = new LinkedList<>();
        position = new Vector<Integer>(2);
        int start_x = 0, start_y = 0;
        size = Integer.parseInt(br.readLine());
        space = new int[size][size];
        Shark baby_shark = new Shark();
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if(space[i][j] == 9){
                    baby_shark.setX(j);
                    baby_shark.setY(i);
                }
            }
        }
        // 계속 돌려야함 큐가 비어있을 때 까지
        searchFish(baby_shark);
    }
    static boolean searchFish(Shark baby_shark) {

    }
}
/* 두번째 생각 */
//    static int searchFish(int y_pos, int x_pos, int move) {
//        int mv = move;
//        int cur_space = space[y_pos][x_pos];
//        position.clear();
//        if (0 < cur_space && shark_size > cur_space) {
//            eaten_fish++;
//            space[y_pos][x_pos] = 0;
//            if (eaten_fish == shark_size) {
//                shark_size++;
//                eaten_fish = 0;
//            }
//            // y위치가 1이상일 경우에만 상단으로 가볼 수 있음.
//            if (y_pos > 0) {
//                position.add(y_pos - 1, x_pos);
//                queue.add(position);
//                position.clear();
//            }
//            // x 위치가 1이상인 경우에만 좌측으로 가볼 수 있음.
//            if (x_pos > 0) {
//                position.add(y_pos, x_pos - 1);
//                queue.add(position);
//                position.clear();
//            }
//            // x위치가 맨 오른쪽이라면 오른쪽 더 탐색 불가능.
//            if (x_pos < size - 1) {
//                position.add(y_pos, x_pos + 1);
//                queue.add(position);
//                position.clear();
//            }
//            // y위치가 맨아래라면 더 아래 탐색 안됨
//            if (y_pos < size - 1) {
//                position.add(y_pos + 1, x_pos);
//                queue.add(position);
//                position.clear();
//            }
//            position = queue.poll();
//            searchFish(position.get(0), position.get(1), mv + 1);
//        }
//        // y위치가 1이상일 경우에만 상단으로 가볼 수 있음.
//        if (y_pos > 0) {
//            position.add(y_pos - 1, x_pos);
//            queue.add(position);
//            position.clear();
//        }
//        // x 위치가 1이상인 경우에만 좌측으로 가볼 수 있음.
//        if (x_pos > 0) {
//            position.add(y_pos, x_pos - 1);
//            queue.add(position);
//            position.clear();
//        }
//        // x위치가 맨 오른쪽이라면 오른쪽 더 탐색 불가능.
//        if (x_pos < size - 1) {
//            position.add(y_pos, x_pos + 1);
//            queue.add(position);
//            position.clear();
//        }
//        // y위치가 맨아래라면 더 아래 탐색 안됨
//        if (y_pos < size - 1) {
//            position.add(y_pos + 1, x_pos);
//            queue.add(position);
//            position.clear();
//        }
//    }

/* 첫번째 생각 */
//    int mv=move;
//    int top = space[y_pos-1][x_pos];
//    int left = space[y_pos][x_pos-1];
//    int right = space[y_pos][x_pos+1];
//    int bottom = space[y_pos+1][x_pos];
//        if(0< top && shark_size > top){
//        eaten_fish++;
//        if(eaten_fish== shark_size) {
//            shark_size++;
//            eaten_fish=0;
//        }
//        mv = searchFish(x_pos,y_pos-1,move+1);
//    }
//        else if(0< left && shark_size > left){
//        eaten_fish++;
//        if(eaten_fish== shark_size) {
//            shark_size++;
//            eaten_fish=0;
//        }
//        mv = searchFish(x_pos-1,y_pos,move+1);
//    }
//        else if(0< right && shark_size > right){
//        eaten_fish++;
//        if(eaten_fish== shark_size) {
//            shark_size++;
//            eaten_fish=0;
//        }
//        mv = searchFish(x_pos+1,y_pos,move+1);
//    }
//        else if(0< bottom && shark_size > bottom){
//        eaten_fish++;
//        if(eaten_fish== shark_size) {
//            shark_size++;
//            eaten_fish=0;
//        }
//        mv = searchFish(x_pos,y_pos+1,move+1);
//    }
//    searchFish(x_pos,y_pos-1,mv+1);
//    searchFish(x_pos-1,y_pos,mv+1);
//    searchFish(x_pos+1,y_pos,mv+1);
//    searchFish(x_pos-1,y_pos+1,mv+1);
