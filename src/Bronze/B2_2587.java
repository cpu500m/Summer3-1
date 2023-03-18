package Bronze;

import java.io.*;
import java.util.Arrays;

public class B2_2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[5];
        int avg = 0;
        for(int i = 0 ; i < 5 ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            avg += arr[i];
        }
        avg = avg / 5;
        Arrays.sort(arr);
        bw.write(avg+"\n"+arr[2]);
        bw.flush();
    }
}
