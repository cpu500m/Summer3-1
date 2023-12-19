package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_30979 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        if(sum >= t)
            bw.write("Padaeng_i Happy");
        else bw.write("Padaeng_i Cry");
        bw.flush();
    }
}
