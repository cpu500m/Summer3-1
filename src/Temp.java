import java.util.*;
import java.io.*;

/**
 * @author : paulkim
 * @description :
 * @packageName : PACKAGE_NAME
 * @fileName : Temp
 * @date : 2024-10-18
 */
public class Temp {

    public static void main(String[] args)  throws IOException {
        int solution = solution(2, new int[]{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7});
        System.out.println(solution);
    }
    public static int solution(int coin, int[] cards) throws IOException {
        final int TARGET = cards.length+1;
        final int START = cards.length/3;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            return o1 - o2;
        });

        // 카드 번호 기준 (인덱스 기준 아님)
        boolean[] isVisited = new boolean[cards.length+1];


        // < num , 등장 round >
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < START ; i++){
            map.put(cards[i], 0);
        }
        for(int i = START; i<cards.length ;i++){
            map.put(cards[i], ((i-START)/2) +1);
        }

        for(int i = 0 ; i< START ; i++){
            if(map.get(TARGET - cards[i]) == 0){
                isVisited[cards[i]] = true;
                isVisited[TARGET-cards[i]] = true;
                pq.add(0);
            }
        }

        int curIndex = START;
        int curCoin = coin;
        int curRound = 1;
        while(curIndex < cards.length){
            int card1 = cards[curIndex++];
            int card2 = cards[curIndex++];

            if(card2 == TARGET - card1){
                pq.add(2);
            }
            else{
                if(map.get(TARGET-card1) == 0){
                    pq.add(1);
                } else if(map.get(TARGET-card1) < curRound){
                    pq.add(2);
                }
                if(map.get(TARGET-card2) == 0){
                    pq.add(1);
                } else if(map.get(TARGET-card2) < curRound){
                    pq.add(2);
                }
            }
            if(pq.size() < 1) break;
            curCoin -= pq.poll();
            if(curCoin < 0) break;
            curRound++;
        }

        return curRound;
    }
}
