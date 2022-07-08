// 0층 : 1 2 3 4 5 6 7
// 1층 : 1 3 6 10
// 2층 : 1 4 10
package Bronze;

import java.io.*;

public class B1_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop_count = Integer.parseInt(br.readLine());
        int[][] apartment = new int[15][15];
        int sum=0;
        int k , n;
        for(int i =0 ; i < 15; i++)
            apartment[0][i] = i;
        for(int i = 1 ; i < 15; i++)
            for(int j = 0; j < 15 ; j++) {
                for(int a = 0 ; a<= j ; a++)
                    sum+=apartment[i-1][a];
                apartment[i][j] = sum;
                sum=0;
            }
        for(int i = 0 ; i< loop_count ; i++){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(apartment[k][n])+"\n");
        }
        bw.flush();
    }
}
