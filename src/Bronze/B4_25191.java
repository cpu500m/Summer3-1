package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_25191 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()) / 2 + Integer.parseInt(st.nextToken());
        bw.write(s > n ? String.valueOf(n): String.valueOf(s));
        bw.flush();
    }
}
