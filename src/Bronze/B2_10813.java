package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        initArr(n, arr);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            swap(st, arr);
        }

        appendResult(sb, n, arr);
        bw.write(sb.toString());
        bw.flush();
    }

    private static void appendResult(StringBuilder sb, int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]+" ");
        }
    }

    private static void swap(StringTokenizer st, int[] arr) {
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int temp = arr[a-1];
        arr[a-1] = arr[b-1];
        arr[b-1] = temp;
    }

    private static void initArr(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
    }
}
