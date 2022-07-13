// 1. 왼쪽 맨위가 흰색인 경우
// 2. 왼쪽 맨위가 검정색인 경우
package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S4_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int row_start = 0;
        int col_start = 0 ;
        int opt_count = Integer.MAX_VALUE;
        int count = 0;
        String str;
        char[][] board = new char[row][col];
        for(int i = 0 ; i <row ; i++) {
            str = br.readLine();
            for (int j = 0; j < col; j++)
                board[i][j] = str.charAt(j);
        }
        // 브루트포스
        while(row_start <= row-8 && col_start <=col-8) {
                for (int i = row_start; i < row_start+8; i++) {
                    for (int j = col_start; j < col_start+8; j++) {
                        if( ( (i-row_start)+(j-col_start)) %2 == 0){
                            if(board[i][j] == 'W')
                                count++;
                        }
                        else{
                            if(board[i][j] == 'B')
                                count++;
                        }
                    }
                }
                if(opt_count > count)
                    opt_count = count;
                count = 0;
                for (int i = row_start; i < row_start + 8; i++) {
                    for (int j = col_start; j < col_start+ 8; j++) {
                        if( ( (i-row_start)+(j-col_start)) %2 == 0){
                            if(board[i][j] == 'B')
                                count++;
                        }
                        else{
                            if(board[i][j] == 'W')
                                count++;
                        }
                    }
                }
            if(opt_count > count)
                opt_count = count;
            count = 0;

            if(row-8 > row_start)
                row_start++;
            else if( col-8 > col_start) {
                row_start=0;
                col_start++;
            }
            else
                break;
        }
        bw.write(String.valueOf(opt_count));
        bw.flush();
    }
}
