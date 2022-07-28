package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_9184 {
    private static int[][][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a, b, c;
        arr = new int[21][21][21];
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i< 21 ; i++) {
            for(int j = 0 ; j< 21 ; j++) {
                arr[0][i][j] = 1;
                arr[i][0][j] = 1;
                arr[i][j][0] = 1;
            }
        }
        for(int i = 1; i < 21; i++){
            for(int j = 1 ; j <21 ; j++){
                for(int k = 1 ; k <21 ; k++){
                    if( i< j && j< k){
                        arr[i][j][k] = arr[i][j][k-1]+arr[i][j-1][k-1]-arr[i][j-1][k];
                    }
                    else
                        arr[i][j][k] = arr[i-1][j][k]+arr[i-1][j-1][k]+arr[i-1][j][k-1]-arr[i-1][j-1][k-1];
                }
            }
        }
        while (a != -1 || b != -1 || c != -1) {
            sb.append("w("+a+", "+b+", "+c+") = "+w(a,b,c)+"\n");
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int w(int a, int b,int c){

        if( a <= 0 || b<=0 || c<=0)
            return 1;
        else if(a >20 || b>20 || c>20)
            return arr[20][20][20];
        return arr[a][b][c];
    }
}
