//  https://st-lab.tistory.com/119님 코드를 참조했습니다
package Gold;

import java.io.*;
import java.util.StringTokenizer;
public class G4_2580 {
    private static final int SIZE = 9;
    private static int[][] arr;
    private static StringBuilder sb;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();
        arr = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
    }
    public static void sudoku(int row, int col) throws IOException {
        if(col ==9){
            sudoku(row+1,0);
            return;
        }
        if(row == 9){
            for(int i = 0 ; i < SIZE ; i++){
                for(int j = 0 ; j < SIZE ; j++)
                    sb.append(arr[i][j]+" ");
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            System.exit(0);
        }
        if( arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if(promising(row, col, i)){
                    arr[row][col] = i;
                    sudoku(row,col+1);
                }
                arr[row][col] =0;
            }
        }
        else
            sudoku(row,col+1);
    }
    public static boolean promising(int row, int col, int value) {
        // 같은 열 검사
        for (int i = 0; i < SIZE; i++) {
            if (arr[row][i] == value)
                return false;
        }
        for (int i = 0; i < SIZE; i++) {
            if (arr[i][col] == value)
                return false;
        }
        int row_start = (row / 3) * 3;
        int col_start = (col / 3) * 3;
        for (int i = row_start; i < row_start + 3; i++){
            for (int j = col_start; j < col_start + 3; j++)
                if (arr[i][j] == value)
                    return false;
        }
        return true;
    }
}
