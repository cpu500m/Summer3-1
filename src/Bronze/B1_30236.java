package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_30236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = 1;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if(cur == arr[j])
                    cur++;
                if(j != n-1)
                    cur++;
            }
            sb.append(cur + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
