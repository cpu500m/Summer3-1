/* 2020-06-21 두번째로 푼 문제. */
// 이동거리가 1 , 2 , 3 , 4 ... 이렇게 1씩 증가하고,
// 마지막 이동거리는 1이라는 점에서
// 두 지점 사이 거리가 1이 아닌이상 무조건 1씩 두번은 이동 해야한다는 점을 이용함.
package Gold;

import java.util.Scanner;

public class G5_1011 {
    public static void main(String[] args) {
        // count loop
        int loop_count ;
        int x_pos, y_pos;
        // x_pos와 y_pos 차이
        int diff;
        // 한번에 움직일 거리
        int move = 1;
        // 장치 작동 횟수
        int move_count =0;
        Scanner scanner = new Scanner(System.in);
        loop_count = scanner.nextInt();
        for(int i = 0 ; i <loop_count; i++){
            x_pos = scanner.nextInt();
            y_pos = scanner.nextInt();
            move = 1; // move 초기화
            move_count = 0 ; // move_count 초기화
            if(x_pos >= y_pos ) { // 입력 범위 벗어난 경우는 예외처리 해야하는데 실행 시간 더걸릴까봐 걍 안함
                System.out.println("x지점 위치가 y지점 위치보다 작아야 합니다.");
                return ;
            }
            diff = y_pos - x_pos;
            while(diff > 0){
                if(diff - move*2 < 0) {
                    if ( diff - move < 0){
                        move--;
                        continue;
                }
                    else {
                        diff -= move;
                        move_count++;
                        continue;
                    }
                }
                diff-= 2*move;
                move_count+=2;
                move++;
            }
            System.out.println(move_count);
        }

    }
}
