package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(),",");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            arr = calculate(arr);
        }
        for (int i = 0; i < arr.length; i++) {
            bw.write(String.valueOf(arr[i])+(i == arr.length-1 ? "" : ","));
        }
        bw.flush();
    }

    private static int[] calculate(int[] arr) {
        int[] res = new int[arr.length - 1];
        for (int i = 0; i < arr.length-1; i++) {
            res[i] = arr[i+1]-arr[i];
        }
        return res;
    }
}
