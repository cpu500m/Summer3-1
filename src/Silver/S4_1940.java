package Silver;

import java.io.*;
import java.util.StringTokenizer;

// 4* 4MB 넉넉

public class S4_1940 {

    public static final int SIZE = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[SIZE];
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = 0; i <= (m-1)/2; i++) {
            int min = arr[i] > arr[m-i] ? arr[m-i] : arr[i];
            arr[i] -=min;
            arr[m-i] -= min;
            cnt += min;
        }
        if (m % 2 == 0) {
            cnt += arr[m/2]/2;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
