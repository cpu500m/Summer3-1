package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S4_30404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        cnt = logic(n, k, arr, cnt);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int logic(int n, int k, int[] arr, int cnt) {
        int cur = 0;
        while (cur < n) {
            int time = arr[cur] + k;
            while (time >= arr[cur]){
                cur++;
                if(cur >= n) break;
            }
            cnt++;
        }
        return cnt;
    }
}
