package Silver;

import java.io.*;

public class S5_1652 {
    private final static char WALL = 'X';
    private final static char EMPTY = '.';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] =str.charAt(j);
            }
        }

        // 걍 N최대 100인데 무식하게 하지 뭐
        int cur = 0;
        int r_cnt = 0, c_cnt =0;
        // 가로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] ==EMPTY) {
                    if(cur == 2)
                        continue;
                    cur++;
                } else cur = 0;
                if(cur == 2) r_cnt++;
            }
            cur = 0;
        }

        // 세로
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[j][i] ==EMPTY) {
                    if(cur == 2)
                        continue;
                    cur++;
                } else cur = 0;
                if(cur == 2) c_cnt++;
            }
            cur = 0;
        }

        bw.write(r_cnt + " "+c_cnt);
        bw.flush();
    }
}
