package Bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1_30088 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Integer[] total = new Integer[n];
        Arrays.fill(total,0);
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            for (int j = 0; j < p; j++) {
                total[i] += Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(total);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += (total[i]*(n-i));
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
