package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] set = new int[6];
        set[0] = 1;
        set[1] = 1;
        set[2] = 2;
        set[3] = 2;
        set[4] = 2;
        set[5] = 8;
        int[] have = new int[6];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            have[i] = Integer.parseInt(st.nextToken());
            sb.append(set[i]-have[i]+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
