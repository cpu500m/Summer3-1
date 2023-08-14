package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class S4_1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Long[] arr = new Long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i]-i <0 ?  0 : (arr[i]-i);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
