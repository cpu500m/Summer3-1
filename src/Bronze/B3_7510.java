package Bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3_7510 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(arr);
            sb.append("Scenario #" + (i+1) + ":\n");

            if(Math.sqrt(arr[0]*arr[0] + arr[1]*arr[1]) ==arr[2])
                sb.append("yes\n\n");
            else sb.append("no\n\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
