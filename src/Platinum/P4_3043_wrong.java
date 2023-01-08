// 일단 그리디로 풀 수 있을거같은데
// 무엇을 기준으로 선택을 만들어가느냐...
// 음... 일단 각 행과 열에 단 하나의 탱크가 존재해야 한다는 점이있고..
// 예제 출력들을보니깐
// 1번부터 N번 탱크까지 순번대로 돌아가면서 진행하되 K번째 탱크 순번일때
// 현재 K번째 탱크가 속한 행 , 열 모두에 다른 탱크가 존재한다면 순번을 넘기는거같음.

// 대충 일단 추측을 먼저해보자면

// 1. 현재 행에 다른 탱크가 있는지 검사한다.
// 2. 현재 열에 다른 탱크가 있는지 검사한다.
// 3 . 1 , 2 모두 참일 경우 순번을 다음으로 넘긴다. ( 1번으로. )
// 4. 1번만 참이라면 행을 옮기는데 좌측 또는 우측으로 이동해야하는데 이 때 각 행 별로 비어있는지 여부를 저장하는 배열을 하나 둬서
// 이용하면 좋을것 같음.
// 5 . 2번만 참이라면 열을 옮기는데 이떄도 역시 4번과 같은 배열을 하나만들어서 더 적은 이동 거리인 곳으로 이동하는 식으로.
// 6 . 순번을 다음 차례로 넘김. ( 1번으로. )

// 흠.. 예제 출력 3을보면 이러한 로직 구성은 아닌거같은데..
// 일단 해보자.

// 구현을 했는데
// 틀려서 왜 틀렸지? 생각을 해본결과
//  1번 2번
//  3번 4번
//
// 위처럼 탱크가 있으면 아예 진행이 안됨 ㅋㅋ
// 앞으로는 생각좀 충분히 해보고 구현으로 들어가야겠다 ^^;;

package Platinum;

import java.io.*;
import java.util.StringTokenizer;

public class P4_3043_wrong {
    static class Tank{
        int x,y;
        Tank(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 그냥 직관성을 위해 한행 + 열 더 쓰는거로..
        // row_check와 col_check 는 현재 행 또는 열에 1개라도 있으면 true.
        boolean[] row_check = new boolean[N+1];
        boolean[] col_check = new boolean[N+1];
        // 얘네는 두 개 이상 있으면 true.
        boolean[] row_over_two = new boolean[N+1];
        boolean[] col_over_two = new boolean[N+1];
        Tank[] tank = new Tank[N+1];

        // 현재 순번
        int cur_tank = 1;
        // 현재 탱크 위치
        int cur_x , cur_y;
        long move;
        int move_pos =0;
        long result = 0, cnt;
        // index
        int i , row , col;

        int loop_cnt = 0;

        // 입력 처리
        for(i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            tank[i] = new Tank(row,col);
            if(row_check[row])
                row_over_two[row] = true;
            if(col_check[col])
                col_over_two[col] = true;
            row_check[row] = true;
            col_check[col] = true;
        }

        /*          로직        */
        while(loop_cnt < N) {
            // 종료조건
            loop_cnt++;
            cur_x = tank[cur_tank].x;
            cur_y = tank[cur_tank].y;
            // 이동 횟수
            move = Integer.MAX_VALUE;
            // 이동한 후 이전 행 또는 열에 하나의 탱크만 존재하는지를 체크하기 위한 변수
            cnt = 0;
            // 현재 행에 두 개 이상의 탱크가 있는가?
            if (row_over_two[cur_x]) {
                // 현재 열에 두 개 이상의 탱크가 있는가?
                if (col_over_two[cur_y]) {
                    cur_tank = (cur_tank+1)%(N+1) == 0 ? 1 : (cur_tank+1)%(N+1);
                    loop_cnt = 0;
                    continue;
                }
                // 현재 열에 나(현재 탱크)만 있다면 , 행을 바꿔줘야함. 비어있는 행을 찾는다.

                // 루프 돌리며 최적인 곳을 찾음.
                for(i = 1; i <= N ; i++){
                    if(!row_check[i])
                        if(move > Math.abs(cur_x - i)) {
                            move = Math.abs(cur_x - i);
                            move_pos = i;
                        }
                }
                if(cur_x < move_pos){
                    // 탱크 이동시킴
                    for(i = cur_x ; i < move_pos ; i++)
                        sb.append(cur_tank + " D\n");
                }
                else if( cur_x > move_pos){
                    // 탱크 이동시킴
                    for(i = cur_x ; i > move_pos ; i--)
                        sb.append(cur_tank + " U\n");
                }
                tank[cur_tank].x = move_pos;
                // 이동 시킨곳에 나 혼자 위치한거니까 row_check 값을 바꿔줌.
                row_check[move_pos] = true;
                // 루프 돌면서 이전에 있던 행에 하나의 탱크만 존재하는지를 확인.
                for(i = 1 ; i <= N ; i++) {
                    if (tank[i].x == cur_x) {
                        cnt++;
                        if(cnt > 1)
                            break;
                    }
                }
                if(cnt < 2)
                    row_over_two[cur_x] = false;
                loop_cnt = 0;
                result+= move;
            }
            else if (col_over_two[cur_y]) {
                for(i = 1; i <= N ; i++){
                    if(!col_check[i])
                        if(move > Math.abs(cur_y - i)) {
                            move = Math.abs(cur_y - i);
                            move_pos = i;
                        }
                }
                if(cur_y < move_pos){
                    // 탱크 이동시킴
                    for(i = cur_y ; i < move_pos ; i++)
                        sb.append(cur_tank + " R\n");
                }
                else if( cur_y > move_pos){
                    // 탱크 이동시킴
                    for(i = cur_y ; i > move_pos ; i--)
                        sb.append(cur_tank + " L\n");
                }
                tank[cur_tank].y = move_pos;
                // 이동 시킨곳에 나 혼자 위치한거니까 col_check 값을 바꿔줌.
                col_check[move_pos] = true;
                // 루프 돌면서 이전에 있던 행에 하나의 탱크만 존재하는지를 확인.
                for(i = 1 ; i <= N ; i++) {
                    if (tank[i].y == cur_y) {
                        cnt++;
                        if (cnt > 1)
                            break;
                    }
                }
                if(cnt < 2)
                    col_over_two[cur_y] = false;
                loop_cnt = 0;
                result+= move;
            }
            cur_tank = (cur_tank+1)%(N+1) == 0 ? 1 : (cur_tank+1)%(N+1);
        }
        bw.write(result+"\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
