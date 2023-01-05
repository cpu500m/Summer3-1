// 일단 좀 생각해봤는데
// 보내는 마을 번호 -> 받는 마을 번호 순으로 정렬은 일단 해야할거같음.
// 우선 그렇게 하고 세부 로직을 짜는걸로.
// 가장 먼저 생각나는 것은 각 주문별로 박스 몇개를 실질적으로 배달하는게 최적인지를 기록하는 int 배열을 만들어서 기록해 놓는 방식.
//예를 들어   보 받 상자 수      용량
//           1 6   10         40
//           2 3   30
//           2 4   40
//           4 6   10
//           5 6   20

// 위와 같다면 1번주문에서 10개 , 2번 주문에서 30개 , 3번 주문에서 첫번째 주문 상자를 빼고 10개 싣고 하는건데
// 이게 최악의 경우에는 1+2 +3 + ... + 10000 번의 루프를. 즉 , 10001*5000 번 루프를 돌게 됨.
// 그리고 그 각각의 루프내에서 용량과 현재 박스 수 비교 등도 해야하고.
// 뭔가 아슬아슬하게 시간 제한에는 통과할것 같지만.. 일단 다른방법이 있는지 좀더 생각해보기로 함.

// 잠깐동안 생각해서 생각난건 받는 마을 번호의 max 값을 항상 기록해놓자는거임.
// 우선순위 큐를 사용해서 받는 마을 번호를 저장해 놓으면 될거같음. 내부 구성은 최대힙으로.
// 그러면 이제 시간문제도 충분 할 것 같네 ㄱㄱ 해보자
// 추가로 우선순위 큐를 구성할 때 해당 주문의 번호도 같이 넣어줘야 편할거같음.
// 그를 위한 클래스가 Max_info

// 근데이게 처음에 생각한거랑 다르게 경우가 너무많고 코드가 너무 복잡해져서 다른 방식을 생각해봄

// x부터 y까지 배달하는거라 치면
// x부터 y-1 까지 현재 트럭에 실린 박스 갯수를 누적합 형식으로 계산해 보는 식으로 하면 될거같음.. 그대로한번 해봄
package Gold;

import java.io.*;
import java.util.*;

public class G2_8980 {

    static class Delivery_info{
        int send , receive , box;
        Delivery_info(int send, int receive, int box){
            this.send = send;
            this.receive = receive;
            this.box = box;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken()), capacity = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int result = 0 ;
        // 누적합을 이용할때 사용하는 인덱스
        int send , receive , box;

        int[] sum = new int[n+1];
        Delivery_info[] info = new Delivery_info[m];

        // index
        int i , j;

        // 누적합 0으로 초기화
        for( i = 0 ; i < n+1 ; i++)
            sum[i] = 0;

        for(i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            info[i] = new Delivery_info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // 위에서 써놓은 기준대로 정렬
        Comparator<Delivery_info> comparator = new Comparator<Delivery_info>() {
            @Override
            public int compare(Delivery_info o1, Delivery_info o2) {
                if(o1.receive == o2.receive)
                    return o2.send - o1.send;
                return o1.receive - o2.receive;
            }
        };
        Arrays.sort(info , comparator);

//         간단한 디버깅은 이거로 ㄱㄱ
//        for(i = 0 ; i < m ; i++)
//            bw.write(info[i].send+" "+info[i].receive+" "+info[i].box+"\n");


        // 로직
        for( i = 0 ; i < m ; i++){
            send = info[i].send;
            receive = info[i].receive;
            box = info[i].box;
            for(j = send ; j < receive ; j++){
                if(sum[j] == capacity || box == 0) {
                    box = 0;
                    break;
                }
                if(sum[j]+ box > capacity){
                    box = capacity - sum[j];
                    sum[j] = capacity;
                }
                else{
                    sum[j] +=box;
                }
            }
            result+= box;
        }



        bw.write(String.valueOf(result));
        bw.flush();
    }
}

// 실패한 흔적들 ;;

//    static class Max_info implements Comparable<Max_info>{
//        int receive, box;
//        Max_info(int receive, int box){
//            this.receive = receive;
//            this.box = box;
//        }
//
//        @Override
//        public int compareTo(Max_info o) {
//            if(o.receive == this.receive)
//                return this.box - o.box;
//             return o.receive - this.receive;
//        }
//    }