/* 2022-06-24 6번째로 푼 문제 */
// 1번 컴퓨터와 2번 컴퓨터가 연결 돼어 있으면 a[1][2], a[2][1] == true
// 즉 , 0번째 행과 열은 공간 낭비가 그렇게 크지 않으므로 (문제에서 요구하는 메모리 크기는 충분하므로) 그냥 버림.
// java에서 boolean 배열은 자동으로 false 값으로 초기화 되는 것 확인함.
package Silver;

import java.util.Scanner;

public class S3_2606 {
    // 인자로 하나하나 전달해주는 것 보다는 그냥 클래스 변수로 선언하는게 나을 것 같아서 이렇게 선언
    private static boolean[][] connect;
    private static boolean[] infection;
    private static int count;
    private static int infection_count;

    public static void main(String[] args) {
        int com1 , com2;
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        // 연결 여부 체크
        connect = new boolean[count+1][count+1];
        // 감염 여부 체크
        infection = new boolean[count+1];
        infection_count = 0;
        int loop_count = scanner.nextInt();

        // 먼저 연결 해주고.
        // 아래 루프는 안해도 상관없지만 그래도 의미를 살리기 위해.
        for(int i = 1 ; i <count+1; i++)
            connect[i][i] = true;
        for(int i = 0 ; i <loop_count ; i ++) {
            com1 = scanner.nextInt();
            com2 = scanner.nextInt();
            connect[com1][com2]= true;
            connect[com2][com1] = true;
        }
        infection[1] = true;
        // 1번 컴퓨터부터 시작
        checkInfection(1);
        // 감염 컴퓨터 수 출력
        System.out.print(infection_count);
    }
    private static void checkInfection(int start){
        // start 번째 컴퓨터와 그래프 상에서 연결 돼 있다면 감염.
        for(int i = 1 ; i < count+1; i++){
            if(connect[start][i] == true && infection[i] == false){
                infection[i] = true;
                infection_count++;
                checkInfection(i);
            }
        }

    }
}
