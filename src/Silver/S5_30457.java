package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_30457 {

    public static final int SIZE = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[SIZE];

        addCnt(br, n, cnt);

        int result = getResult(cnt);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static int getResult(int[] cnt) {
        int result = 0;
        for (int i = 0; i < SIZE; i++) {
            result+= cnt[i];
        }
        return result;
    }

    private static void addCnt(BufferedReader br, int n, int[] cnt) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cnt[cur] < 2) cnt[cur]++;
        }
    }
}
