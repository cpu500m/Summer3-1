package Silver;

import java.io.*;

public class S1_1992 {
    private static int[][] arr;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        sb= new StringBuilder();
        arr = new int[N][N];
        String str;
        for(int i = 0 ; i < N ; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++)
                arr[i][j] = Character.getNumericValue(str.charAt(j));
        }
        make_quadTree(0, 0, N);
        bw.write(sb.toString());
        bw.flush();
    }
    public static void make_quadTree(int x_start , int y_start, int n){
        int first = arr[x_start][y_start];
        for(int i = x_start ; i < x_start+n ; i++){
            for(int j = y_start ; j < y_start+n ; j++){
                if(first != arr[i][j]){
                    sb.append("(");
                    make_quadTree(x_start ,y_start, n/2);
                    make_quadTree(x_start,y_start+n/2,n/2);
                    make_quadTree(x_start+n/2, y_start,n/2);
                    make_quadTree(x_start+n/2,y_start+n/2, n/2);
                    sb.append(")");
                    return ;
                }
            }
        }
        if(first == 0)
            sb.append("0");
        else if(first == 1)
            sb.append("1");
    }
}
