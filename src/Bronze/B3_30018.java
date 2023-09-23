package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_30018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] before = new int[n];
        int[] after = new int[n];
        processInput(br, n, before);
        processInput(br, n, after);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (before[i] > after[i] ? before[i] -after[i] : 0);
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void processInput(BufferedReader br, int n, int[] arr) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
