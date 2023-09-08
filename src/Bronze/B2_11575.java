package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_11575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                sb.append(convert2Char(a, b, str, j));
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static char convert2Char(int a, int b, String str, int j) {
        return (char) ('A' + ((a * (str.charAt(j) - 'A') + b) % 26));
    }
}
