// 우선 그래프형태로 나타내서 생각해보았는데,
// 시작점부터 거리 1000 이내의 지점들을 큐에 하나씩 넣어가면서
// 최종적인 좌표에 도달할수 있는지를 따져보면 되지않을까 싶음
package Gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos_9205{
    int num,x,y;
    Pos_9205(int num,int x, int y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

public class G5_9205 {
    static boolean[] visit;
    static int[][] distance;

    static Pos_9205[] pos;

    static Queue<Pos_9205> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());
        int num_of_store;
        int i, j, k;
        StringTokenizer st;

        for(i = 0 ; i < test_case; i++) {
            queue = new LinkedList<>();
            num_of_store = Integer.parseInt(br.readLine());
            pos = new Pos_9205[num_of_store+2];
            visit = new boolean[num_of_store+2];
            distance = new int[num_of_store+2][num_of_store+2];
            for(j = 0 ; j < num_of_store+2; j++) {
                st = new StringTokenizer(br.readLine());
                pos[j] = new Pos_9205(j,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                // 거리계산
                for(k = 0; k< j ; k++){
                    distance[k][j] = Math.abs(pos[k].x-pos[j].x)+Math.abs(pos[k].y-pos[j].y);
                    distance[j][k] = distance[k][j];
                }
            }
            if(bfs(num_of_store+2))
                bw.write("happy\n");
            else bw.write("sad\n");
        }
        bw.flush();
    }
    static boolean bfs(int num_of_pos){
        visit[0] = true;
        Pos_9205 cur_p;
        int i;
        queue.add(pos[0]);
        while(!queue.isEmpty()){
            cur_p = queue.poll();
            for( i = 0 ; i < num_of_pos ; i++) {
                if(visit[i]== true || distance[cur_p.num][i] > 1000)
                    continue;
                else{
                    if(i == num_of_pos-1){
                        return true;
                    }
                    visit[i] = true;
                    queue.add(pos[i]);
                }
            }
        }
        return false;
    }
}
