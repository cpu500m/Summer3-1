package Gold;

import Silver.S3_14501;

import java.io.*;
import java.util.StringTokenizer;

public class G5_15486 {
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
            days[i] = new Day(i, i + t - 1, p);
        }

        /*  로직  */
        // N번의 스케쥴을 체크한다.
        // N번 조건문 체크하기 좀 그래서 시작은 따로 뺌
        if(days[0].end < N)
            record[days[0].end] = days[0].pay;
        for (int i = 1; i < N; i++) {
            Day cur = days[i];
            int c_e = cur.end;
            int c_p = cur.pay;
            // 고려 대상이 아니면 제외
            if (c_e <= N - 1) {
                if (record[i - 1] + c_p > record[c_e])
                    record[c_e] = record[i - 1] + c_p;
            }
            record[i] = record[i] > record[i - 1] ? record[i] : record[i - 1];
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (res < record[i])
                res = record[i];
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
