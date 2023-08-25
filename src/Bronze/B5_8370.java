package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_8370 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        ans += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
