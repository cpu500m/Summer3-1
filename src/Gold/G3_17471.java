package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G3_17471
 * @date : 2024-09-29
 */
public class G3_17471 {

    private static int answer = -1;
    private static int N;
    private static boolean[][] isConnected;
    private static int[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        /* 1. 입력 처리 */
        N = Integer.parseInt(br.readLine());
        people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

         isConnected = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int next = Integer.parseInt(st.nextToken())-1;
                isConnected[i][next] = true;
            }
        }

        boolean[] isIncluded = new boolean[N];
        backTracking(isIncluded,0);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void backTracking(boolean[] isIncluded, int index){
        /* 백트래킹 루프 */
        for (int i = index; i < N; i++) {
            isIncluded[i] = true;
            backTracking(isIncluded,i+1);
            isIncluded[i] = false;
        }

        // 하나의 구역도 포함하지 않다면 건너뛴다
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(isIncluded[i]) count++;
        }
        if(count == 0 || count == N) return;

        /* 각각의 구역이 연결되어 있는지 확인. */
        boolean[][] curConnect = new boolean[N][N];

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                curConnect[i][j] = isConnected[i][j];
            }
        }

        // bfs로 연결
        for (int i = 0; i < N; i++) {
            boolean[] isVisited = new boolean[N];
            isVisited[i] = true;
            boolean curTeam = isIncluded[i];
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if(curConnect[i][j] && curTeam == isIncluded[j]) {
                    queue.add(j);
                    isVisited[j] = true;
                }
            }
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for (int j = 0; j < N; j++) {
                    if(!isVisited[j] && curConnect[cur][j] && curTeam == isIncluded[j]) {
                        queue.add(j);
                        isVisited[j] = true;
                        curConnect[i][j] = true;
                    }
                }
            }
        }

        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < N; i++) {
            boolean curTeam = isIncluded[i];
            if(curTeam) {
                score1 += people[i];
            }else{
                score2 += people[i];
            }
            for (int j = i+1; j < N; j++) {
                // 같은 팀인데 연결 안되어 있다면 끝
                if(isIncluded[j] == curTeam && !curConnect[i][j]) {
                        return;
                    }
                }
            }
        /* 최적 값 구하기 */
        if(answer == -1){
            answer = Math.abs(score1-score2);
        } else{
            answer = Math.min(Math.abs(score1-score2),answer);
        }
    }
}
