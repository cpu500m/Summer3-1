// 흠.. 풀어본저 있는유형이다 ㅇㅇ 백트래킹
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1987 {
    static int result = 0;
    static char[][] arr;
    static boolean[] check;

    static int[] x_dir = {-1,1,0,0};
    static int[] y_dir = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*  입력  처리  */
        // index
        int i,j;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R=  Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new char[R+2][C+2];
        check =new boolean[26];
        String temp = br.readLine();
        // 우선 외곽을 1행1열 알파벳으로 둘러싸놓음.
        for(i = 0 ; i <R+2 ; i++)
            Arrays.fill(arr[i], temp.charAt(0));

        for(i = 1; i <= R; i++){
            for(j= 1 ; j <= C; j++)
                arr[i][j] = temp.charAt(j-1);
            if( i!= R)
                temp = br.readLine();
        }

        search(1,1,1);

        bw.write(String.valueOf(result));
        bw.flush();
    }
    static void search(int r, int c, int cnt){

        if(cnt > result)
            result = cnt;

        //index
        int i;
        int cur_x, cur_y;

        check[arr[r][c] - 'A'] = true;

        for(i = 0 ; i < 4 ; i++){
            cur_x = r+x_dir[i];
            cur_y = c+y_dir[i];
            if(check[arr[cur_x][cur_y]-'A'] == false){
                search(cur_x,cur_y, cnt+1);
            }
        }
        check[arr[r][c] - 'A'] = false;
    }
}
