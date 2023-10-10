package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int len = n.length() - 1;
        int res = 0;
        for (int i = len; i >= 0; i--) {
            char c = n.charAt(i);
            double mul = Math.pow(b, len - i);
            if ('A' <= c)
                res += ((c-'A') +10)*(int)mul;
            else res += ((c - '9') + 9)*(int) mul;
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
