// 우선은 주유소에서의 연료양을 기준으로 내림차순으로 정렬해 보았는데
//  만약 목적지가 원래의 예시대로 25, 시작 연료가 10이고
//  원점에서의 거리        연료양
//    15                 10
//    13                 7
//    10                 5
//    4                  4
//    5                  2
//
// 라면 15, 10 두 지점에서 넣는 것이 최적임. 그래서 이런 경우를 커버하는 방식을 좀 더 생각해봄
// 이를 커버하기 위해 두번쨰로 생각난 방식은
// 원점에서 거리를 기준으로 오름차순으로 정렬하는거임.
// 그래서 일단 연료가 다 달을때까지 가면서 만나는 지점의 주유소 연료양을 우선순위 큐에 넣어놓는거임. ( 연료 양을 기준으로 내림차순으로)
// 그래서 목적지까지 아직 다다르지 못했다면 우선순위 큐에서 하나뺴서 그만큼 채우고 또 가보고 , 그런식으로 하면
// 시간도 크게 문제없어보이고 메모리도 역시 넉넉할 것같음.
// 그대로 한번 구현해봄.

package Gold;

import java.io.*;
import java.util.*;

public class G2_1826 {

    static class gas_station{
        int distance , fuel;
        gas_station(int distance,int fuel){
            this.distance = distance;
            this.fuel = fuel;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 결과 값
        int result = 0;
        Queue<Integer> priority_queue = new PriorityQueue<>(Collections.reverseOrder());
        // index;
        int i;
        int town , cur_fuel;
        // 입력 처리
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        gas_station[] gas_stations = new gas_station[N+1];

        for(i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            gas_stations[i] = new gas_station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        gas_stations[N] = new gas_station(Integer.parseInt(st.nextToken()), 0);
        cur_fuel = Integer.parseInt(st.nextToken());

        // 출발점 기준 오름차순 정렬
        Arrays.sort(gas_stations, new Comparator<gas_station>() {
            @Override
            public int compare(gas_station o1, gas_station o2){
                return o1.distance- o2.distance;
            }
        });
        // 로직
        for(i = 0 ; i <= N ; i++){
            if(cur_fuel >= gas_stations[i].distance){
                priority_queue.add(gas_stations[i].fuel);
            }
            else {
                while(cur_fuel < gas_stations[i].distance && !priority_queue.isEmpty()){
                    cur_fuel += priority_queue.poll();
                    result++;
                }
                if (priority_queue.isEmpty() && cur_fuel < gas_stations[i].distance){
                    result = -1;
                    break;
                }
                priority_queue.add(gas_stations[i].fuel);
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
