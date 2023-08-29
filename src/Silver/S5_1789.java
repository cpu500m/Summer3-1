package Silver;

import java.io.*;

public class S5_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long cur_val = 1;
        int add_val = 2;
        int cnt = 1;
        long s = Long.parseLong(br.readLine());
        while (cur_val < s) {
            cur_val += (add_val++);
            cnt++;
        }
        if (cur_val != s)
            bw.write(String.valueOf(cnt - 1));
        else bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
