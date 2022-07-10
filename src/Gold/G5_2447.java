package Gold;

import java.io.*;

public class G5_2447 {
    private static char[][] arr;
    private static char[][] star;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new char[4][4];
        for(int i = 1 ; i <4 ; i++){
            for(int j = 1 ; j <4 ; j++)
                arr[i][j] = '*';
        }
        arr[1][1] = ' ';
        int n = Integer.parseInt(br.readLine());
        star = new char[n+1][n+1];
        storeStar(n,n,1);
    }
    public static void storeStar(int n, int x, int y){
        if( n == 3) {
//            for (int i = 0; i < 3; i++){
//                for (int j = 0; j < 3; j++)
//                    star[y + i][x];
//        }
//            return ;
        }
        else{
            storeStar(n/3, n/3, n/3);
            storeStar(n/3, 2*n/3, 2*n/3);
            storeStar(n/3, n, n);
        }
    }
}
