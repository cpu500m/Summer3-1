package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class S4_2217 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 로직 ( 정렬 후 최대중량 찾기)
        Arrays.sort(arr, Collections.reverseOrder());
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]*(i+1) > max)
                max = arr[i] * (i + 1);
        }

        bw.write(String.valueOf(max));
        bw.flush();

    }
}
