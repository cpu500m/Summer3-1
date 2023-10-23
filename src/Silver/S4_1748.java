package Silver;

import java.io.*;

// 9 + 90 + 900 + 9_000 + 90_000 +... + 90_000_000 + 1( 각 자리 별)
// 위에다 *1 + *2 + ... + *8 + *9
// 결과로 만들어지는 최악의 경우 길이 < 2^32

public class S4_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int len = 0;
        int cur = 10;
        int cur_cnt = 9;
        int cur_len = 1;
        while (cur <= n) {
            len += cur_cnt*cur_len;

            // 다음 자릿수로
            cur*=10;
            cur_cnt *= 10;
            cur_len++;
        }
        len += cur_len*(n - ((cur/10)-1));
        bw.write(String.valueOf(len));
        bw.flush();
    }
}
