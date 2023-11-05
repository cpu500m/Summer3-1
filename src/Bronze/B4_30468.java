package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_30468 {

    public static final int KIND_COUNT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < KIND_COUNT; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        int obj = Integer.parseInt(st.nextToken()) * 4;
        bw.write(condition(sum, obj));
        bw.flush();
    }

    private static String condition(int sum, int obj) {
        return sum >= obj ? "0" : String.valueOf(obj - sum);
    }
}
