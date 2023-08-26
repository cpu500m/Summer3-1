// 시간이 없어서 이렇게 짰지만 이건 진짜 worst code 그자체
package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_3035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int zr = Integer.parseInt(st.nextToken());
        int zc = Integer.parseInt(st.nextToken());

        char[][] input = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                input[i][j] = str.charAt(j);
            }
        }

        char[][] arr = new char[r * zr][c * zc];

        int cp = 0;
        int cur_x = 0;
        // 가로 한 줄씩
        for (int i = 0; i < r*zr; i++) {
            if(cp == 0 || cp == zr) {
                // arr[i]번째줄에 input[i][j] 의 내용을 input[i][j+(zc-1)] 까지 넣어야함
                int cur_y = 0;
                for (int j = 0; j < c*zc; j += zc) {
                    for (int k = 0; k < zc; k++) {
                        arr[i][j + k] = input[cur_x][cur_y];
                    }
                    cur_y++;
                }
                if(cp == zr)
                    cp = 1;
                else cp++;
                cur_x++;
            }
            else{
                arr[i] = arr[i-1];
                cp++;
            }
        }

        for (int i = 0; i < zr*r; i++) {
            for (int j = 0; j < zc*c; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
