package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int Y = 0;
        int M = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            Y += ((cur/30)+1)*10;
            M += ((cur/60)+1)*15;
        }
        if (Y == M) {
            bw.write("Y M " +Y);
        } else if (Y > M) {
            bw.write("M " +M);
        }
        else bw.write("Y "+Y);
        bw.flush();
    }
}
