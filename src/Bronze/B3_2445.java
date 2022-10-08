package Bronze;

import java.io.*;

public class B3_2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N+1][2*N];
        for(int i = N; i  > 0; i--){
            for(int j = 1; j < N ; j++)
                arr[i][j]= ' ';
            for(int j = N ; j >N-i ; j--)
                arr[i][j] = '*';
            for(int j = N; j < N+i ; j++)
                arr[i][j] = '*';
        }
        for(int i = N ; i  > 0; i--){
            for(int j = 1 ; j < N+i ; j++)
                bw.write(arr[i][j]);
            bw.write("\n");
        }
        for(int i = 2 ; i  < N+1; i++){
            for(int j = 1 ; j < N+i ; j++)
                bw.write(arr[i][j]);
            if( i !=N )
                bw.write("\n");
        }
        bw.flush();
    }
}
