package Silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info_2644{
    int cnt, num;
    Info_2644(int cnt, int num){
        this.cnt = cnt;
        this.num = num;
    }
}
public class S2_2644 {

    static boolean[][] relation;
    static boolean[] visit;
    static Queue<Info_2644> queue;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(br.readLine());
        int temp1, temp2;
        queue = new LinkedList<>();
        // idx
        int i,j;
        relation = new boolean[n+1][n+1];
        visit = new boolean[n+1];
        for(i = 0 ; i< count; i++){
            st = new StringTokenizer(br.readLine());
            temp1 = Integer.parseInt(st.nextToken());
            temp2 = Integer.parseInt(st.nextToken());
            relation[temp1][temp2] = true;
            relation[temp2][temp1] = true;
        }
        bfs(new Info_2644(0,start),end, n);
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static void bfs(Info_2644 s,int end, int n){
        int i , j;
        Info_2644 info;
        visit[s.num] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            info = queue.poll();
            if(info.num == end){
                result = info.cnt;
                break;
            }
            for(i = 1; i <= n; i++){
                if(visit[i] == false && relation[info.num][i] == true){
                    visit[i] = true;
                    queue.add(new Info_2644( info.cnt+1,i));
                }
            }
        }
    }
}
