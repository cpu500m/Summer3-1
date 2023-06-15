package Bronze;

import java.io.*;

public class B4_14038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        int[] arr = new int[7];
        arr[0] = -1; arr[1] = arr[2] = 3; arr[3] = arr[4] = 2;
        arr[5] = arr[6] = 1;
        for (int i = 0; i < 6; i++) {
            if( br.readLine().equals("W")) cnt++;
        }
        bw.write(String.valueOf(arr[cnt]));
        bw.flush();
    }
}
