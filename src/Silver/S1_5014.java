package Silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info_5014{
    int floor,cnt;
    Info_5014(int floor ,int cnt){
        this.floor = floor;
        this.cnt = cnt;
    }
}
public class S1_5014 {
    static boolean[] visit;
    static Queue<Info_5014> queue;
    static int result = -1;
    static int F,S,G,U,D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visit = new boolean[F+1];
        queue = new LinkedList<>();
        bfs(new Info_5014(S,0));
        if(result == -1)
            bw.write("use the stairs");
        else bw.write(String.valueOf(result));
        bw.flush();
    }
    static void bfs(Info_5014 s){
        int up , down;
        Info_5014 info;
        visit[s.floor] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            info = queue.poll();
            if(info.floor == G){
                result = info.cnt;
                break;
            }
            if(info.floor+U <= F)
                up = info.floor+U;
            else up = info.floor;
            if(info.floor-D > 0)
                down = info.floor-D;
            else down = info.floor;

            if( visit[up] == false){
                visit[up] = true;
                queue.add(new Info_5014(up,info.cnt+1));
            }

            if( visit[down] == false ){
                visit[down] = true;
                queue.add(new Info_5014(down,info.cnt+1));
            }
        }
    }
}
