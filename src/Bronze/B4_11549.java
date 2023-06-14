package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_11549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = Integer.parseInt(br.readLine());
        int res = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            if (ans == Integer.parseInt(st.nextToken())) {
                res++;
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
