package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_6246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n + 1];
        int start, distance;
        int empty_space = 0;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());
            for (int j = start; j < n + 1; j += distance) {
                arr[j] = true;
            }
        }
        for (int i = 1; i < n + 1; i++){
            if (!arr[i])
                empty_space++;
        }
        bw.write(String.valueOf(empty_space));
        bw.flush();
    }
}
