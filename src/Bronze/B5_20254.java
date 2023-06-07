package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_20254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] co = new int[4];
        co[0] = 56; co[1] = 24; co[2] = 14; co[3] = 6;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res += co[i] * Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
