package Bronze;

import java.io.*;

public class B2_1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[br.readLine().charAt(0)- 'a']++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= 5)
                sb.append((char)(i+'a'));

        }
        if(sb.length() > 0) bw.write(sb.toString());
        else  bw.write("PREDAJA");
        bw.flush();
    }
}
