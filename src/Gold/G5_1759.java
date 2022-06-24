/* 2022-06-23 네번째로 푼 문제 */
// backtracking 방식으로 다음 번 node가 promising한지 먼저 보고 promising하다면 진입.
// 올바르게 결괏값을 찾았다면 ArrayList ( result )에 결괏값 저장하고
// Collections 클래스가 지원하는 sort 메서드를 이용하여 정렬한 후
// 결과를 출력.
package Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class G5_1759 {
    static boolean[] mark;
    static char[] answer;
    static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args) {
        int count;
        int actual_count;
        int print_count = 0; // actual_count와 같아지면 출력 ( 모음 자음 개수 따져서)
        int cons_count = 0 , vow_count =0 ;// 자음, 모음 카운트
        Scanner scanner = new Scanner(System.in);

        actual_count = scanner.nextInt();
        count = scanner.nextInt();
        char[] set = new char[count];
        mark = new boolean[count];
        answer = new char[actual_count];
        for(int i = 0 ; i <count; i++)
            set[i] = scanner.next().charAt(0);

        for(int i = 0 ; i <count; i++)
            mark[i] = false;

        for(int i = 0 ; i < count ; i++) {
            mark[i] = true;
            searchSolution(set, set[i], actual_count, print_count, cons_count, vow_count);
            for(int a = 0 ; a <count;a++)
                mark[a] = false;
        }
        // 결과 정렬
        Collections.sort(result);
        // 출력
        for(int i = 0 ; i < result.size() ; i++) {
            System.out.print(result.get(i));
            if( i != result.size()-1)
                System.out.println();
        }
    }
    public static void searchSolution(char[] set, char alphabet,final int actual_count, int print_count, int cons_count, int vow_count){
        answer[print_count]=alphabet;
        print_count++;
        switch(alphabet){
            case 'a' :
            case 'e' :
            case 'i' :
            case 'o':
            case 'u' :
                vow_count++;
                break;
            default:
                cons_count++;
        }
        for(int i = 0 ; i <set.length; i++){
            // 정답 알파벳 개수와 같아지면 출력
            if(print_count == actual_count) {
                // 모음 자음 개수 검사
                if (vow_count > 0 && cons_count > 1)
                    result.add(String.valueOf(answer));
                return ;
            }
            // mark가 false인 경우 ( 아직 탐색 안한 알파벳) && 진입 전에 promising한 node로 가는지 검사
            if (!mark[i] && Character.compare(alphabet, set[i]) < 0) {
                mark[i] = true;
                searchSolution(set, set[i], actual_count, print_count, cons_count, vow_count);
                mark[i] = false;
            }
        }
    }
}
