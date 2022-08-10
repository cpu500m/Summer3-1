package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S4_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];
        for(int i = 0 ; i < N ; i++)
            coin[i] = Integer.parseInt(br.readLine());
        int cur_choice =N-1;
        int cur_coin = coin[cur_choice];
        int sum =0;
        int cnt=0;
        // 1. cur_best 추가
        // 2. 적정성검사
        // 3. 해 검사
        while(sum != K) {
            sum += cur_coin;
            cnt++;
            if (sum > K) {
                sum -= cur_coin;
                cnt--;
                cur_coin = coin[--cur_choice];
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
