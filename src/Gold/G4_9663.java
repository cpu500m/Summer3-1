// 2학년 때 배웠던 n-queens 문제.
// State spanning tree를 그려 가는 길이 유망한지 보고
// 유망하지 않다면 다음 경로 방문.
package Gold;

import java.io.*;

public class G4_9663 {
    private static int N;
    private static int[] col;
    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        col = new int[N+1];
        result = 0;
        queens(0);
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static void queens(int row_number){
        if(promising(row_number)){
            if( row_number == N)
                result++;
            else{
                for(int col_number = 1; col_number <= N;  col_number++) {
                    col[row_number + 1] = col_number;
                    queens(row_number+1);
                }
            }

        }
    }
    static boolean promising(int row_number){
        int k=1;
        boolean flag= true;
        while(k < row_number && flag){
            if(col[row_number] == col[k] || Math.abs(col[row_number]-col[k])== Math.abs(row_number-k))
                flag = false;
            k++;
        }
        return flag;
    }
}
