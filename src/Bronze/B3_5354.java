package Bronze;

import java.io.*;
import java.util.Arrays;

public class B3_5354 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] arr;
        int size;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            size = Integer.parseInt(br.readLine());
            arr = new char[size][size];

            for(int j = 0 ; j < size; j++){
                Arrays.fill(arr[j], '#');
            }
            for(int j = 1 ; j< size-1 ; j++){
                for(int k = 1; k < size-1;k++)
                    arr[j][k] = 'J';
            }
            for(int j = 0 ; j< size ; j++){
                for(int k = 0; k < size;k++)
                    bw.write(arr[j][k]);
                bw.write("\n");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
