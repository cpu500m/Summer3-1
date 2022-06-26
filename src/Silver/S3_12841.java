/* 2022-06-26 10번째로 푼 문제 */
// 한번 dynamic programming기법으로 풀어봄.
// 최대 100,000행. 2열 ( 왼쪽선택, 오른족선택)의 long형 배열을 만들어서 한번 해봄.
// 문제 다시보니깐 횡단보도 한번만 건널 수 있다고해서
// 그냥 최대 10만번루프 돌리면서 1번쨰 보도 건널때 ... 이렇게 해서 최솟값 구하면 될듯 ;;
package Silver;

import java.util.Scanner;

public class S3_12841 {
    public static void main(String[] args) {
        final int LEFT = 0;
        final int RIGHT = 1;
        long min_value= Long.MAX_VALUE;
        int cross_num=0;
        long left_sum=0;
        Scanner scanner = new Scanner(System.in);
        int count= scanner.nextInt();
        int[] cross = new int[count+1];
        for(int i = 1 ; i< count+1 ; i ++)
            cross[i]=scanner.nextInt();
        int[] left = new int[count];
        int[] right = new int[count];

        for(int i = 1 ; i< count ; i ++)
            left[i]=scanner.nextInt();
        for(int i = 1 ; i< count ; i ++)
            right[i]=scanner.nextInt();

        long right_sum=0;
        for(int i = 1 ; i< count ; i++)
            right_sum+=right[i];




        for(int i = 1 ; i < count+1 ; i ++){
            left_sum+=left[i-1];
            right_sum-=right[i-1];
            if( min_value > left_sum+cross[i]+right_sum){
                min_value = left_sum+cross[i]+right_sum;
                cross_num = i;
            }
        }
        System.out.print(cross_num+" "+min_value);
    }
}
