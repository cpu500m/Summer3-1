// 삼성 SW 아카데미에서 풀어봄
// 조금 다르긴 했지만 비슷하니깐..
package Gold;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class G2_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> high_queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> low_queue = new PriorityQueue<>();

        /*      로직      */
        int cur = Integer.parseInt(br.readLine());
        sb.append(cur + "\n");
        int input;
        for (int i = 1; i < N; i++) {
            // 입력을 받고 cur 값과 비교때림
            input = Integer.parseInt(br.readLine());
            if (input > cur) {
                low_queue.add(input);
                // 짝수 개 만큼 있을 경우라면 그냥 지나친다. 하지만 홀수 개 만큼 있다면 왼쪽으로 한번 밀어줘야한다.
                if( i % 2 == 0){
                    high_queue.add(cur);
                    cur = low_queue.poll();
                }
            }
            else {
                high_queue.add(input);
                // 이번에는 짝수 개 만큼 있을 경우 오른쪽으로 한칸 밀어줘야한다.
                if(i % 2 == 1){
                    low_queue.add(cur);
                    cur = high_queue.poll();
                }
            }
            sb.append(cur + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
