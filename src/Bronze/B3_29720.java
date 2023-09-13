package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_29720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int min = n - m*k > 0 ? n- m*k : 0;
        int max = n - (m * (k-1)+1) > 0 ? n - (m * (k-1)+1)  : 0;
        bw.write(min + " " + max);
        bw.flush();
    }
}
