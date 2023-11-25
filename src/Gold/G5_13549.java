// 내일하자 코테 때문에 머리아프다
package Gold;

import java.io.*;
import java.util.*;

public class G5_13549 {

    public static final int MAX = 100001;

    static class Info{
        int time;
        int diff;
        int pos;

        public Info(int time, int pos, int diff) {
            this.time = time;
            this.pos = pos;
            this.diff = diff;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[MAX];
        Queue<Info> queue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.time == o2.time) {
                    return o1.diff - o2.diff;
                }
                return o1.time - o2.time;
            }
        });

        int diff= k;
        if(n != 0) diff = k % n;
        queue.add(new Info(0, n,diff));
        visited[n] = true;
        int result = 0;

        while (!queue.isEmpty()) {
            Info cur = queue.poll();
            if(cur.diff == 0){
                result = cur.time;
                break;}

            if(cur.pos+1 < MAX && !visited[cur.pos+1]){
                queue.add(new Info(cur.time+1, cur.pos+1, k % (cur.pos+1)));
                visited[cur.pos+1]= true;
            }

            if(cur.pos-1 == 0 && k ==0)
                result = cur.time+1;

            if(cur.pos-1 > 0 && !visited[cur.pos-1]){
                queue.add(new Info(cur.time+1, cur.pos-1, k % (cur.pos-1)));
                visited[cur.pos-1]= false;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
