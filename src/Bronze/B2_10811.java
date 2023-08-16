package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int[] temp = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken());
            int cnt = 1;
            update_arr(temp,arr);
            for (int j = s; j < e; j++) {
                arr[j] = temp[e- cnt++];
            }
        }
        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(arr[i]+" "));
        }
        bw.flush();
    }
    private static void update_arr(int[] cp_arr,int[] org_arr) {
        for (int i = 0; i < org_arr.length; i++) {
            cp_arr[i] = org_arr[i];
        }
    }
}
