/* 2022-06-27 11번째로 푼 문제*/
// 일단 가장 먼저 생각나는 방법이
// 연결그래프를 이용한 Dynamic programming 방식.
// n개의 건물이 있다고하면
// [n+1][n+1] size의 int형 배열 만듦. ( 0<= 배열 내부 값 <=100_000 이므로)
//  0번째 행과열은 버리고. (어차피 메모리 512MB제한이니까 넉넉하므로)
// n행의 의미는 n번째 건물
// 그리고 1번건물을 짓는데 10초가 걸린다 라고 생각하는게 아니고
// 1번에서 2번까지 가는데 10초가 걸린다. 라고 한번 생각해 보는거임.
// 그렇게 int[n+1][n+1] distance배열을 만든 다음
// 마지막 목적지부터 시작해서 한칸씩 건너가는거임. 그니까
// seachRoute(int 목적지) { for (i = 1 ~~~ ) distance]i][목적지]최대인곳찾음 , searchRoute( i )
//  이런식으로 . 그렇게해서 함수가 실행될 때마다 값을 더해가면 목적지 까지의 값을 찾을 수 있지 않을까 생각함.

// 그런데 곰곰히 다시 생각해보니까
// 예를들어 5 -> 2가 10000초 걸리고 , 2-> 4가 1초 걸리고
// 1 -> 3 이 10초 , 3 -> 4 가 100초 걸린다면
// 위 알고리즘 대로라면 4를 짓기위해 120초가 필요하다고 할거임. 근데 실제로는 10011초가 정답.
// 그래서 다시 생각해봄.

// 위에 쓴 것처럼 searchRoute(~~~) 이런식으로 있을때
// distance 배열이 단순히 점 사이의 거리가 아니고
// 점사이의 누적 거리라면 위 알고리즘이 올바르게 동작할것이라고 생각이 들었음.
// 문제의 예시를 예로 들면 2에서 4까지의 거리가 1이아니고 누적 거리인 11이 저장돼있는거임.
// 그러면 올바르게 동작.
// 일단 시작지점이 어딘지 알 수 없으니까
// 목적지 (목표건물) 부터 출발해서 거꾸로 거슬러 올라가야 할 것 같음.
// 그러면 아까의 생각에서 조금 수정해서 distance[i][목적지] ( i != 목적지) 값이 0이상인 i를 모두 추적해 봐야할거같음.
// 해서 그중 최댓값을 가지는 애를 찾아서 최종적으로 [목적지][목적지] 값을 더해주면 완료.

// distance는 연결 그래프의 거리를 나타냄.
// dp에 각 건물까지의 max시간을 저장.

package Gold;

import java.util.Scanner;

public class G3_1005 {
    static int[][] distance;
    static long[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop_count = scanner.nextInt();
        int building_count;
        int rule_count;
        int first, second;
        int destination;
        for(int a = 0; a <loop_count; a++) {
            building_count = scanner.nextInt();
            rule_count = scanner.nextInt();
            distance=new int[building_count+1][building_count+1];
            dp = new long[building_count+1];
            for(int i = 1 ; i <building_count+1; i++)
                dp[i] = -1;
            for(int i = 1 ; i < building_count+1; i++){
                distance[i][i]= scanner.nextInt();
            }
            for(int k = 0 ; k < rule_count; k++) {
                first= scanner.nextInt();
                second =scanner.nextInt();
                distance[first][second] = distance[first][first];
            }
            destination = scanner.nextInt();
            System.out.println(SearchRoute(destination)+distance[destination][destination]);
        }

    }
    public static long SearchRoute(int destination){
        long max=0;
        long temp;
        if(dp[destination] != -1)
            return dp[destination];
            for(int i =1 ; i < distance.length; i++){
                if(distance[i][destination] > 0){
                    if( i == destination)
                        continue;
                    else{
                        temp = SearchRoute(i);
                        if(max < distance[i][destination] +temp)
                         max = distance[i][destination] +temp;
                    }
                }
            }
            dp[destination] = max;
            return max;
    }
}
