package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G4_13422
 * @date : 2024-10-12
 */
public class G4_13422 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] money = new int[N + M - 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                money[i] = Integer.parseInt(st.nextToken());
            }

            // 배열 끝에 0 ~  (window_size - 1) index 추가
            for (int i = N; i < money.length; i++) {
                money[i] = money[i - N];
            }

            // sliding window
            int result = 0;
            int prefixSum = 0;

            for (int i = 0; i < M; i++) {
                prefixSum += money[i];
            }

            if (prefixSum < K) {
                result++;
            }

            // 예외 케이스 : window size == 배열 크기
            if (N == M) {
                sb.append(result).append("\n");
                continue;
            }

            for (int i = M; i < money.length; i++) {
                prefixSum += (money[i] - money[i - M]);
                if (prefixSum < K) {
                    result++;
                }
            }

            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
