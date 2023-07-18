package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int min = 200_001;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int v = arr[i] + arr[(arr.length - 1) - i];
            if (v < min) {
                min = v;
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
    }
}
