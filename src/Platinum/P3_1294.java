// 문제 읽고 조금 생각한뒤 떠올린건
// 그러면 반대순서로
// 사전순에서 가장 뒤로 밀리는것부터 넣는다면? 어떨까 라는 생각이 떠오름.
// 근데 예제 2보니깐 또 그렇게는 안됨.
// 그래서 그냥 주어진 문자열들 처음부터 고려하면서
// 사전순으로 가장 앞선애부터 넣는데
// 그러면 우선순위 같은애가 여러개라면?
// 그러면 그떄는... 흠..
// 해당 문자열을 현재 문자와 같지 않은애가 나올때까지 가서 사전순으로 오름차순 정렬한 우선순위 큐에 넣는다?
// 그거는 또 안되는게 CBA CBC 이렇게 주어지면 A와 C를 비교하는것이아니고 B ,B를 보고 들어감
// 아니 생각해보니까 그러면 그냥 우선순위 큐 이용해서
// 사전순으로 가장 앞선애 하나 뽑아서 첫번쨰 문자 넣고, 큐에서 지우고,
// 다시 하나 지운 문자열 넣고. 해서 만들면되는거 아님? 그대로해봄
// 간단하게 생각했는데
// 이게 문자길이다른데 첫문자가 같은경우에 와 이게 진짜 생각하는게 ;; 1시간은 생각한듯

package Platinum;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P3_1294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder temp = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        // index
        int i;
        Queue<String> p_queue = new PriorityQueue<>(new Comparator<String>() {
            char comp1 , comp2;
            @Override
            public int compare(String o1, String o2) {
                comp1 = o1.charAt(0);
                comp2 = o2.charAt(0);
                if(o1.length() != o2.length()){
                    // 첫 문자 다르면 그냥 첫문자 사전순 앞인놈이 우선순위 높음
                    if(comp1 != comp2)
                        return comp1 - comp2;
                    // 첫문자가 같다면?..
                    int i = 1 , start =0,min = Math.min(o1.length(),o2.length()), max = Math.max(o1.length(),o2.length()) ;
                    while(comp1 == comp2 && i < min){
                            comp1= o1.charAt(i);
                            comp2 = o2.charAt(i);
                        i++;
                    }
                    while(comp1 == comp2 && i < max&& start < min){
                        if(min < o1.length()){
                            comp1 = o1.charAt(i);
                            comp2 = o2.charAt(start);
                        }
                        else{
                           comp1 = o1.charAt(start);
                            comp2 =o2.charAt(i);
                        }
                        i++;
                        start++;
                    }
                    start = 0;
                    while (comp1 == comp2 && i <max){
                        if(max == o1.length()){
                            comp1 = o1.charAt(i);
                            comp2 = o1.charAt(start);
                        }
                        else{
                            comp1 = o2.charAt(start);
                            comp2 = o2.charAt(i);
                        }
                        i++;
                        start++;
                    }
                    return comp1 - comp2;
                }
                return o1.compareTo(o2);
            }
        });

        // 입력 처리
        int N = Integer.parseInt(br.readLine());
//        String[] str = new String[N];

        for(i = 0 ; i< N ; i++){
            p_queue.add(br.readLine());
        }

        /* 로직 */
        while(!p_queue.isEmpty()){
            temp.append(p_queue.poll());
            sb.append(temp.charAt(0));
            if(temp.length() > 1) {
                temp = temp.deleteCharAt(0);
                p_queue.add(temp.toString());
            }
            temp.setLength(0);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
