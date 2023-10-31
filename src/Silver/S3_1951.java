package Silver;

import java.io.*;

public class S3_1951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long len = 0;
        long cur = 10;
        long cur_cnt = 9;
        long cur_len = 1;
        while (cur <= n) {
            len += cur_cnt*cur_len;
            len %= 1234567;
            // 다음 자릿수로
            cur*=10;
            cur_cnt *= 10;
            cur_len++;
        }
        len += cur_len*(n - ((cur/10)-1));
        len %= 1234567;
        bw.write(String.valueOf(len));
        bw.flush();
    }
}
