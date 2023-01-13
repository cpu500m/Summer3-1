// 너무 쉬운데 이건?
// 걍 boolean 배열 하나 둬서 기록해놓으면 끝이잖아
// 지민이가 참석한파티에 진실을 아는사람이 있다면 나머지도 모두 진실을 알게될테니 배열값 갱신해주고
// 지민이가 참석한파티에 진실을 아는이가 없다면 거짓말 치고 거짓말 카운트 늘리면되는거고 ㅇㅇ
// 루프를 세보면 최댓값이 50이니깐 50*50*50  n^3해도 충분한데?

// 근데 빠르게 구현했는데 TC보니깐 이게 약간 현실이랑 다른게 이거는
// 과거에 거짓말하고 미래에 진실을 말하는경우도 고려해야하네
// 그니깐
// 1이 진실을 알고있는데
// 1번째 파티에 2가 참여했어. 그럼 그리디하게보면 일단 거짓말을 치는거지.
// 근데 2번째 파티에 1과 2가 참여했어. 그러면 과거로가서 다시 2한테 진실을 얘기해줘야돼.
// 그래서 그런걸좀 고려해야겠다 .
// 그럼 어떻게 고려할건가?
// 그러면 약간 전염 시키는 방식으로 해보자.
// 일단 boolean배열을 [파티수][사람수] 로 만들고 .
// 진실알고있는애들 CHECK 하면서 큐에 넣으면서 해보는 그런느낌으로다가 가자

package Gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // index
        int i, j;
        int participant_cnt;
        int result = 0;
        int cur;
        boolean flag;


        /*      입력  처리      */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] know = new boolean[N+1];
        boolean[][] check = new boolean[M][N+1];
        Queue<Integer> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int fact_cnt = Integer.parseInt(st.nextToken());
        for(i = 0 ; i < fact_cnt ; i++){
            cur = Integer.parseInt(st.nextToken());
            know[cur] = true;
            queue.add(cur);
        }
        for(i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            participant_cnt = Integer.parseInt(st.nextToken());
            for(j = 0 ; j < participant_cnt ; j++){
                check[i][Integer.parseInt(st.nextToken())] = true;
            }
        }

        /*      로직      */
        while (!queue.isEmpty()){
            cur = queue.poll();
            for(i = 0; i < M ; i++){
                // 어떤 파티에 참석했었다면 , 진실을 모르는 사람들을 감염(?)시켜야한다
                if(check[i][cur] == true){
                    for(j = 1 ; j <= N ; j++){
                        if(check[i][j] == true && know[j] == false){
                            queue.add(j);
                            know[j] = true;
                        }
                    }
                }
            }
        }
        // 진실 아는사람 다 체크했으니 이제 답을 도출해낼 차례.
        result = M;
        for( i = 0 ; i < M ; i++){
            for( j = 1; j <= N ; j++)
                if(check[i][j] == true && know[j] == true){
                    result--;
                    break;
                }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
