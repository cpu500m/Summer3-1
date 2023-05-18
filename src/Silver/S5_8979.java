// 걍 포인터 하나 더 만들면 되는데 귀찮아서 하다보니.... 시간 개 비효율적;;
package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S5_8979 {

    static class Nation{
        int id;
        int gold;
        int silver;
        int bronze;

        public Nation(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Nation[] nations = new Nation[N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            nations[i] = new Nation(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Comparator<Nation> comparator = new Comparator<Nation>() {
            @Override
            public int compare(Nation o1, Nation o2) {
                if(o1.gold == o2.gold){
                    if(o1.silver == o2.silver)
                        return o2.bronze - o1.bronze;
                    return o2.silver - o1.silver;
                }
                return o2.gold - o1.gold;
            }
        };
        Arrays.sort(nations,comparator);
        int rank = 1 , pos = 0;
        Nation temp = new Nation(1,1,1,1);
        for(int i = 0 ; i < N ; i++){
            if(nations[i].id == K) {
                pos = i;
                temp = nations[i];
                break;
            }
            rank++;
        }
        for(int i = pos-1 ; i >=0 ; i--){
            if(temp.gold == nations[i].gold && temp.silver == nations[i].silver && temp.bronze == nations[i].bronze)
                rank--;
            else break;
        }
        bw.write(String.valueOf(rank));
        bw.flush();
    }
}
