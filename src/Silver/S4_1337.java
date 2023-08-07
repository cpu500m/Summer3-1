package Silver;

import java.io.*;
import java.util.Arrays;

public class S4_1337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        // idx 4차이 : (arr[i+4] - arr[i]) < 5 ? 0 : (arr[i+4] - arr[i] - 4)
        // idx 3차이 : (arr[i+3] - arr[i]) < 5 ? 1 : (arr[i+3] - arr[i] - 3)
        // idx 2차이 : (arr[i+2] - arr[i]) < 5 ? 2 : (arr[i+2] - arr[i] - 2)
        // idx 1차이 : (arr[i+2] - arr[i]) < 5 ? 1 : (arr[i+1] - arr[i] - 1)
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j < N-i; j++) {
                int val = arr[j+i] - arr[j] < 5 ? 4-i : (arr[j+i] - arr[j] - i);
                if(val < min)
                    min = val;
            }
        }
        bw.write(String.valueOf(min > 3 ? 4 : min));
        bw.flush();
    }
}