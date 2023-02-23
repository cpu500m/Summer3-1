package Bronze;

import java.io.*;
import java.util.Arrays;

public class B2_1371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        Arrays.fill(cnt, 0);
        String str;
        while ((str = br.readLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') continue;
                cnt[str.charAt(i) - 'a']++;
            }
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max)
                max = cnt[i];
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == max)
                sb.append((char) (i + 'a'));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

