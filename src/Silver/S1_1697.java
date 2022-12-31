package Silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class S1_1697 {
    static boolean[] visit;
    static Queue<Integer> queue;
    static int []cnt;
    static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        visit = new boolean[100001];
        cnt = new int[100001];
        queue = new LinkedList<>();

        bfs(start);

        bw.write(String.valueOf(cnt[target]));
        bw.flush();
    }
    static void bfs(int s){
        int up , down, tp;
        int cur;
        visit[s] = true;
        cnt[s] = 0;
        queue.add(s);
        while (!queue.isEmpty()) {
            cur = queue.poll();

            if(cur == target)
                break;

            up = cur+1;
            down = cur-1;
            tp =cur*2;

            if (up <= 100000 && visit[up] == false) {
                visit[up] = true;
                cnt[up] = cnt[cur]+1;
                queue.add(up);
            }
            if (down >= 0 && visit[down] == false) {
                visit[down] = true;
                cnt[down] = cnt[cur]+1;
                queue.add(down);
            }
            if (tp <= 100000 && visit[tp] == false) {
                visit[tp] = true;
                cnt[tp] = cnt[cur]+1;
                queue.add(tp);
            }
        }
    }
}
