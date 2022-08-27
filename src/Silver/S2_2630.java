package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_2630 {
    private static int[][] arr;
    private static int blue_count = 0;
    private static int while_count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        arr = new int[N][N];
        StringTokenizer st ;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        div_paper(0, 0, N);
        sb.append(while_count+"\n");
        sb.append(blue_count);
        bw.write(sb.toString());
        bw.flush();
    }
    public static void div_paper(int x_start , int y_start, int n){
        int first = arr[x_start][y_start];
        for(int i = x_start ; i < x_start+n ; i++){
            for(int j = y_start ; j < y_start+n ; j++){
                if(first != arr[i][j]){
                    div_paper(x_start ,y_start, n/2);
                    div_paper(x_start+n/2,y_start,n/2);
                    div_paper(x_start, y_start+n/2,n/2);
                    div_paper(x_start+n/2,y_start+n/2, n/2);
                    return ;
                }
            }
        }
        if(first == 0)
            while_count++;
        else if(first == 1)
            blue_count++;
    }
}
