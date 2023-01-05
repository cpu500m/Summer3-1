// 그냥 start 좌표 순으로 정렬한다음에
// 만약 현재 점의 end 좌표와 그 전의 start 좌표가 겹치는부분이잇다면 하나로 처리해주면 되는거아닌가? 쉬워보임
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G5_2170 {
    static class Line{
        int start , end;
        Line(int start ,int end){
            this.start = start;
            this.end = end;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int pre_end = Integer.MIN_VALUE , end;
        int start;
        int result = 0;

        Line[] lines = new Line[N];
        // index
        int i;

        // 입력처리
        for(i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // start 좌표 순으로 오름차순 정렬
        Arrays.sort(lines, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.start - o2.start;
            }
        });

        // 로직
        for(i = 0 ; i < N ; i++){
            start = lines[i].start;
            end = lines[i].end;
            if(pre_end > start)
                start = pre_end;

            if(end - start <= 0)
                continue;

            pre_end = end;
            result+= end-start;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
