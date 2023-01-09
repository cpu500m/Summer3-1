// 음,,,
// 일단 각 탱크의 x좌표 , y좌표 따로따로 저장해놓은다음에
// 오름차순으로 정렬해서
// 예를들어 x좌표에 대해서만 생각해보면 오름차순으로 일단 x좌표를 정렬.
// 1 , 3 , 4 ,4 와 같이 잇었다면
// N만큼 for 반복문을 돌린다음에
// 3을 2로 ,4를 3으로 땡겨오면 어떨까?
// 근데 만약에 1 1 2 2 라면?
// 그러면 1을 2로 2를 3으로 3을 4로?
// 이건 좀 문제가될거같은데?
// 왜냐면 1을 2로 이동하면 탱크 위치의 중복이 일어날 수 있으니깐.
// 그러면 앞선 예시에서 해당하는 케이스가 없다면
// 뒤부터 반복문을 시작하는거로 다시 해야하나? 일단 좀 더 생각해봄
// 그냥 애초에 시작을 맨 뒤에서부터 시작하는 것은 ?
// 그러면 1 , 1, 2, 2 의경우 맨뒤 2를 4로 , 그다음 2를 3으로  , 그다음 1을 2로 --> 탱크 중복없이 4번이동
// 1 , 3, 4 , 4 의 경우 3번째 4를 3으로.. 여기서 탱크 중복이 발생
// 그러면 앞선 방식을 차용하되 이동하는 좌표 순으로 내림차순 정렬하는것은?
// 그러면 x , y 좌표 각각에 대해서 이방식을 적용하면 될듯? 한번 ㄱ
// 1 ,1 ,2,2 면 목적지가 1, 2, 3, 4 로 설정되니깐  2 -> 4 , 2->3,1-> 2 순으로 이동하고
// 1 3, 4, 4 면 목적지가 1, 2, 3 , 4니깐 3->2 , 4->3 순으로 이동.
// 그러면 만약에 목표좌표가 더 작다면 오름차순으로 , 크다면 내림차순으로 하면 되겠네
// 잠만 그러면 둘다 있다면 내리는 작업을 먼저해야돼 올리는 작업을 먼저해야돼?
// 이거는 좀 생각해봤는데 고려 안해도될듯?
// 와 ㅋㅋ 하루걸려서 풀었따 레전드 ㅋㅋ

package Platinum;

import java.io.*;
import java.util.*;

public class P4_3043 {
        static class Tank{
            int num , row,col, obj_row , obj_col;
            Tank(int num, int row, int col){
                this.num = num;
                this.row = row;
                this.col = col;
                obj_row = row;
                obj_col = col;
            }
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());

            Tank[] tank = new Tank[N];
            Queue<Tank> low_queue = new PriorityQueue<>(new Comparator<Tank>() {
                @Override
                public int compare(Tank o1, Tank o2) {
                    return o1.obj_row - o2.obj_row;
                }
            });
            Queue<Tank> high_queue = new PriorityQueue<>(new Comparator<Tank>() {
                @Override
                public int compare(Tank o1, Tank o2) {
                    return o2.obj_row- o1.obj_row;
                }
            });
            // index
            int i;
            int move , result = 0;
            Tank cur_tank;
            // 입력 처리
            for( i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                tank[i] = new Tank(i+1,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            // 행부터 시작 ( 행 기준 오름차순 정렬)
            Arrays.sort(tank, new Comparator<Tank>() {
                @Override
                public int compare(Tank o1, Tank o2) {
                    return o1.row - o2. row;
                }
            });
            // 목적지 설정
            for(i = 1 ; i <= N ; i++){
                if(tank[i-1].row != i) {
                    tank[i - 1].obj_row = i;
                    // Up
                    if(tank[i-1].row > tank[i-1].obj_row)
                        low_queue.add(tank[i-1]);
                    else high_queue.add(tank[i-1]);
                }
            }
            while(!low_queue.isEmpty()){
                cur_tank = low_queue.poll();
                move = Math.abs(cur_tank.obj_row - cur_tank.row);
                result+= move;
                for(i = 0 ; i< move ; i++)
                    sb.append(cur_tank.num+" U\n");
            }
            while(!high_queue.isEmpty()){
                cur_tank = high_queue.poll();
                move = Math.abs(cur_tank.obj_row - cur_tank.row);
                result+= move;
                for(i = 0 ; i< move ; i++)
                    sb.append(cur_tank.num+" D\n");
            }
            // 그다음 열에 대해 작업해주는건데.. 코드 개더럽다 ㄹㅇ 근데 바꾸기귀찮다 나중거부터 최적화하자
            Arrays.sort(tank, new Comparator<Tank>() {
                @Override
                public int compare(Tank o1, Tank o2) {
                    return o1.col - o2.col;
                }
            });
            // 목적지 설정
            for(i = 1 ; i <= N ; i++){
                if(tank[i-1].col != i) {
                    tank[i - 1].obj_col = i;
                    // LEFT
                    if(tank[i-1].col > tank[i-1].obj_col)
                        low_queue.add(tank[i-1]);
                    else high_queue.add(tank[i-1]);
                }
            }
            while(!low_queue.isEmpty()){
                cur_tank = low_queue.poll();
                move = Math.abs(cur_tank.obj_col - cur_tank.col);
                result+= move;
                for(i = 0 ; i< move ; i++)
                    sb.append(cur_tank.num+" L\n");
            }
            while(!high_queue.isEmpty()){
                cur_tank = high_queue.poll();
                move = Math.abs(cur_tank.obj_col - cur_tank.col);
                result+= move;
                for(i = 0 ; i< move ; i++)
                    sb.append(cur_tank.num+" R\n");
            }
            bw.write(String.valueOf(result)+"\n"+sb.toString());
            bw.flush();
        }
}