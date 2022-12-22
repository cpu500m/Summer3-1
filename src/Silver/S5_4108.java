package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_4108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken()) , col = Integer.parseInt(st.nextToken());
        char[][] arr;
        int i , j , cnt;
        String str;
        StringBuilder sb = new StringBuilder();
        while(row !=0 && col != 0){
            arr = new char[row+2][col+2];
            for(i = 1 ; i <= row; i++) {
                str = br.readLine();
                for (j = 1; j <= col; j++)
                    arr[i][j] = str.charAt(j-1);
            }
            for(i = 1 ; i <= row; i++) {
                for (j = 1; j <= col; j++) {
                    cnt = 0;
                    if (arr[i][j] == '*')
                        sb.append("*");
                    else{
                        for(int a = -1 ; a <= 1 ; a++)
                            for(int b = -1 ; b <= 1 ; b++){
                                if(arr[i+a][j+b] == '*')
                                    cnt++;
                            }
                        sb.append(cnt);
                    }
                }
                sb.append("\n");
            }

            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
