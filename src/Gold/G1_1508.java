// 흠,,, 이거도 일단 문제를 다 일고 든생각은
// G5_2212와 상당히 비슷한 패턴아닌가? 라는 생각이 들었음.
// 그냥 심판이 위치 할 수 있는 간격 사이사이 거리를 모두 구하고
// 심판 M명을 배치할거니깐 M개의 영역으로 나눠서 보면 되는거아닌가?
// 좀 생각해보니깐 확실히 2212번이랑은 다른게 2212은 영역을 분할할 수 있는 개념이고
// 이거는 걍 M개의 심판을 설치하는 느낌으로 그니깐 3점을 잡고 거리들을 통합해야됨.
// 일단은 뭐 어떻게 되던 사전순으로 뒤에오도록 하는거니까 맨 왼쪽자리에는 무조건 심판한명 놔야함.
// 그거는 일단 시작조건같음
// 그리고나서 생각해보는 것이 트랙 거리인 N은 왜줬을까인데.. 모르겠네;
// 일단 맨 왼쪽에 하나 놓고 시작하니깐
// 맨왼쪽에 놓고,
// distance를 M-1개로 줄여야하는거니까
// 우선 맨왼쪽점과 맨 오른쪽 점 거리차이 / (M-1) 만큼 부터 시작해서
// 하나씩 줄여가면서
// 심판 M명을 배치할 수 있는지 확인하는 식으로 해보기로 함.
// 이게 생각하는데 좀 오래걸렸음;;


package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1_1508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // cur_idx 는 현재 인덱스, d_cnt는 거리를 몇개로 나눠야하는지, standard는 기준잡은 최소 거리
        // 즉 , 최소거리를 최대로 잡고 조금씩 줄여가면서 해볼 예정임.
        int cur_idx = 0, d_cnt, standard, cur_d = 0, cur_cnt, start_idx;
        // index
        int i, j;
        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] pos = new int[K];
        boolean[] check = new boolean[K];
        int[] distance = new int[K - 1];
        st = new StringTokenizer(br.readLine());
        for (i = 0; i < K; i++)
            pos[i] = Integer.parseInt(st.nextToken());
        for (i = 0; i < K - 1; i++) {
            distance[i] = pos[i + 1] - pos[i];
        }

        /*          로직        */
        // 우선 예를들어 심판 4명을 배치해야 한다면 4명 사이의 심판 거리는 3개임.
        d_cnt = M - 1;
        // 최소 거리가 가장 큰 상황에서 스타트. 최소 거리가 가장 큰 상황은 마지막 좌표와 첫점의 좌표의 차를 d_cnt로 나눈 만큼
        // 각 심판들 사이의 거리가 벌려져 있는 경우임.
        standard = (pos[K - 1] - pos[0]) / d_cnt;

        while(standard >0) {
            Arrays.fill(check, false);
            // 맨 왼쪽 지점은 심판 배치하고 스타트
            check[0] = true;
            cur_cnt = 1;
            for (i = 0; i < K - 1; i++) {
                if (cur_cnt == M)
                    break;
                if (cur_d+distance[i] < standard) {
                    cur_d += distance[i];
                }
                else {
                    check[i+1] = true;
                    cur_cnt++;
                    cur_d = 0;
                }
            }
            if (cur_cnt == M)
                break;
            standard--;
            cur_d = 0;
        }
        for (i = 0; i < K; i++) {
            if (check[i])
                bw.write("1");
            else
                bw.write("0");
        }
        bw.flush();

    }
}

