/* 2022-06-26 8번째로 푼 문제 */
// 메모리 제한 2^20 * 2^7 bytes
// int형 배열 4* 1,000 = 4KB . (대략)
//
// 시간제한이 1초이므로 대략 1억번 내로 루프를 돌려야 함.
// 만들 수 있는지 여부를 boolean형 배열인 check라고 만들고
// 추의 무게를 오름차순으로 정렬하고
// 내부에서 루프를 돌며 check배열을 체크한뒤
// O(check배열크기) 만큼 돌면서 check내부에서 가장먼저 나오는 false index를 출력하기로 생각.
// 문제는 check배열의 크기를 너무 크게 잡으면 곤란해서
// check배열의 크기를 좀 고민 했는데 1,000,000만큼의 크기만 잡아도
// 어차피 최대 추의 개수는 1,000개이므로 무조건 false인 애가 하나는 나오기 때문에
// 1,000,000크기의 boolean배열 잡기로 결정.

// 근데 조금 작성해보니까
// check배열을 체크하는 과정에서 nC1 + nC2 + ... + nCn만큼의 시간복잡도가 들거같음.
// 이건 2^n인데 시간조건을 초과하니까
// 다른 방법을 생각해봄.
// 일단 첫번째 원소는 1이어야 하고 ( 그래야 1을 나타낼 수 있으니까)
// 그리고 두번쨰 부터는
// 앞선 추들과 모두 더한 무게가 다음 추와의 무게 차이가
// 2이상 차이난다면 ( 다음 추가 더 크다면)
// 지금까지 추들을 합한무게+1 만큼이 나타낼 수 없는 최솟값은 아닐까 하고 생각해 봄.
package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class G2_2437 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight_count = scanner.nextInt();
        // 루프문 내부에서 추들 무게 합친 값
        int sum = 1;
        boolean flag = true;
        int[] weights = new int[weight_count];
        for(int i = 0 ; i < weight_count ; i++)
            weights[i]= scanner.nextInt();
        Arrays.sort(weights);
        // 첫번째 추 1이 아니면 1을 만들 수 없음.
        if(weights[0] != 1) {
            System.out.print("1");
            return ;
        }
        for(int i =1 ; i < weight_count ; i++){
            if(sum+1< weights[i]){
                System.out.print(sum+1);
                flag = false;
                break;
            }
            sum+=weights[i];
        }
        if(flag)
            System.out.print(sum+1);

        scanner.close();
    }
}
