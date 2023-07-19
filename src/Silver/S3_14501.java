package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_14501 {
    static class Day {
        int start;
        int end;
        int pay;

        public Day(int start, int end, int pay) {
            this.start = start;
            this.end = end;
            this.pay = pay;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // 0 ~ N-1일로 치환. 그게 편하다....
        Day[] days = new Day[N];
        int[] record = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            days[i] = new Day(i , i + t-1, p);
        }

        /*  로직  */
        // N번의 스케쥴을 체크한다.
        for (int i = 0; i < N; i++) {
            Day cur = days[i];
            int c_e = cur.end;
            int c_p = cur.pay;
            // 고려 대상이 아니면 제외
            if(c_e > N-1)
                continue;
            // record의 days[i].end번째 index 값을 갱신 할 수 있는지 검사한다.
            for (int j = 0; j < days[i].start; j++) {
                if(c_p + record[j] > record[cur.end])
                    record[cur.end] = c_p + record[j];
            }
            if(record[cur.end] == 0)
                record[cur.end] = c_p;
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            if( max < record[i])
                max = record[i];
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}
