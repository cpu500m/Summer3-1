// 최대 웅덩이가 10000 개니깐 뭘 생각하든 여유로울거같음
package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S1_1911 {
    static class Pool{
        int start, end;
        Pool(int start ,int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        Pool[] pools = new Pool[N];
        int start , end;
        int cnt, cur_pos = 0;
        int result = 0;

        // index
        int i;

        // 입력처리
        for( i = 0;  i< N ; i++){
            st = new StringTokenizer(br.readLine());
            pools[i] = new Pool(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 시작 좌표기준 오름차순 정렬
        Arrays.sort(pools, new Comparator<Pool>() {
            @Override
            public int compare(Pool o1, Pool o2) {
                return o1.start - o2.start;
            }
        });

        // 로직
        for(i = 0 ; i < N ; i++){
            start = pools[i].start;

            if(start < cur_pos)
                start = cur_pos;
            else
                cur_pos = start;

            end = pools[i].end;

            if(end -start <= 0)
                continue;

            cnt = (end-start) % L == 0 ? (end-start) / L : (end-start) / L +1;

            result+= cnt;
            cur_pos = start+L*cnt;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
