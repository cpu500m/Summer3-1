package Bronze;

import java.io.*;

public class B2_30700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String compareStr = "KOREA";
        int idx =0;
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == compareStr.charAt(idx)) {
                maxLen++;
                idx = (idx+1)%compareStr.length();
            }
        }
        bw.write(String.valueOf(maxLen));
        bw.flush();
    }
}
