package Bronze;

import java.io.*;

public class B4_30045 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.contains("OI") || str.contains("01")) cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
