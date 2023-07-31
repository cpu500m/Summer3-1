package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] row_check = new boolean[n];
        boolean[] col_check = new boolean[m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 'X'){
                    row_check[i] = true;
                    col_check[j] = true;
                }
            }
        }
        int row_cnt = 0;
        int col_cnt = 0;
        for (int i = 0; i < n; i++) {
            if(!row_check[i])
                row_cnt++;
        }
        for (int i = 0; i < m; i++) {
            if(!col_check[i])
                col_cnt++;
        }
        bw.write(String.valueOf(row_cnt > col_cnt ? row_cnt : col_cnt));
        bw.flush();
    }
}
