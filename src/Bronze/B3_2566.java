package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int max = -1;
        int row_idx = 0, col_idx = 0;
        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (max < c) {
                    max = c;
                    row_idx = i;
                    col_idx = j;
                }
            }
        }
        bw.write(max + "\n" + row_idx + " " + col_idx);
        bw.flush();
    }
}
